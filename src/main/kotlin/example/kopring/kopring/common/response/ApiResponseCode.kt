package example.kopring.kopring.common.response

class ApiResponseCode {
    companion object {
        const val ERR_CODE_PREFIX: Int = 1000
    }

    enum class FAIL {
        CommonError,
        UserNotFound,
        DataNotFound;

        fun getErrCode(): Int {
            return ordinal + ERR_CODE_PREFIX
        }
    }
}