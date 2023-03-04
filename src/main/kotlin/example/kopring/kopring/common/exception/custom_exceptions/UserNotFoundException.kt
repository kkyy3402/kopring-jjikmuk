package example.kopring.kopring.common.exception.custom_exceptions

import example.kopring.kopring.common.response.ApiResponseMessages

//유저가 존재하지 않을때 발생하는 Exception
class UserNotFoundException : RuntimeException() {

    override val message: String
        get() = getErrorMessage()

    private fun getErrorMessage(): String {
        return ApiResponseMessages.FAIL.HAS_NO_USER
    }
}