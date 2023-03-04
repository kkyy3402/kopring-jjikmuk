package example.kopring.kopring.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ApiResponse<T>(val header: ApiResponseHeader, val body: Map<String, T>?) {
    companion object {
        fun <T> success(name: String, body: T): ResponseEntity<ApiResponse<T>> {
            val responseData = mapOf(name to body)
            val apiResponse = ApiResponse(ApiResponseHeader(ApiResponseMessages.SUCCESS.MSG, 0), responseData)
            return ResponseEntity(apiResponse, HttpStatus.OK)
        }

        //400
        fun <T> badRequest(message: String, errorEnum: ApiResponseCode.FAIL): ResponseEntity<ApiResponse<T>> {
            val apiResponse = ApiResponse<T>(ApiResponseHeader(message, errorEnum.getErrCode()), null)
            return ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST)
        }

        //401
        fun <T> unauthorized(message: String, errorEnum: ApiResponseCode.FAIL): ResponseEntity<ApiResponse<T>> {
            val apiResponse = ApiResponse<T>(ApiResponseHeader(message, errorEnum.getErrCode()), null)
            return ResponseEntity(apiResponse, HttpStatus.UNAUTHORIZED)
        }

        //403
        fun <T> forbidden(message: String, errorEnum: ApiResponseCode.FAIL): ResponseEntity<ApiResponse<T>> {
            val apiResponse = ApiResponse<T>(ApiResponseHeader(message, errorEnum.getErrCode()), null)
            return ResponseEntity(apiResponse, HttpStatus.FORBIDDEN)
        }

        //500
        fun <T> internalServerError(message: String, errorEnum: ApiResponseCode.FAIL): ResponseEntity<ApiResponse<T>> {
            val apiResponse = ApiResponse<T>(ApiResponseHeader(message, errorEnum.getErrCode()), null)
            return ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}