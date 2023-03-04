package example.kopring.kopring.common.exception

import example.kopring.kopring.common.exception.custom_exceptions.DataNotFoundException
import example.kopring.kopring.common.exception.custom_exceptions.UserNotFoundException
import example.kopring.kopring.common.response.ApiResponse
import example.kopring.kopring.common.response.ApiResponseCode
import example.kopring.kopring.common.response.ApiResponseHeader
import example.kopring.kopring.common.response.ApiResponseMessages
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestController
@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    fun userNoFoundExceptionHandler(e: UserNotFoundException, request: WebRequest): ResponseEntity<ApiResponse<Any>> {
        val header = ApiResponseHeader(e.message, ApiResponseCode.FAIL.UserNotFound.getErrCode())
        return ResponseEntity(ApiResponse(header, null), HttpStatus.UNAUTHORIZED)
    }


    @ExceptionHandler(DataNotFoundException::class)
    fun dataNotFoundExceptionHandler(e: DataNotFoundException, request: WebRequest): ResponseEntity<ApiResponse<Any>> {
        val header = ApiResponseHeader(e.message, ApiResponseCode.FAIL.DataNotFound.getErrCode())
        return ResponseEntity(ApiResponse(header, null), HttpStatus.UNAUTHORIZED)
    }

    //나머지 에러들
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ApiResponse<Any>> {
        val header = ApiResponseHeader(ex.localizedMessage, ApiResponseCode.FAIL.CommonError.getErrCode())
        val apiResponse: ApiResponse<Any> = ApiResponse(header, null)
        return ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}