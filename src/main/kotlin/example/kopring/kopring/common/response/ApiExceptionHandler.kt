package example.kopring.kopring.common.response

object ApiResponseMessages {
    object SUCCESS {
        const val MSG: String = "성공"
    }

    object FAIL {
        const val COMMON_ERROR: String = "알 수 없는 오류가 발생하였습니다."
        const val HAS_NO_USER: String = "해당 유저가 존재하지 않습니다."
        const val HAS_NO_DATA: String = "해당 데이터가 존재하지 않습니다."
    }
}