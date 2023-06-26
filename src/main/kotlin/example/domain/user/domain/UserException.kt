package example.domain.user.domain

import example.common.exception.ClientException
import example.common.exception.ServerException

object UserException {
    /**
     * 유저 정보를 조회할 수 없는 경우
     */
    class NotFound : ClientException {
        constructor(userId: Long) : super(
            message = MESSAGE,
            logMessage = "유저를 찾을 수 없습니다 - (userId: $userId)",
            errorCode = ERROR_CODE,
        )

        constructor(userName: String) : super(
            message = MESSAGE,
            logMessage = "유저를 찾을 수 없습니다 - (userName: $userName)",
            errorCode = ERROR_CODE,
        )

        companion object {
            private const val MESSAGE = "유저 정보를 찾을 수 없습니다."
            private const val ERROR_CODE = "USER.NOT_FOUND"
        }
    }

    /**
     * 유저 도메인과 관련된 서버 쪽 오류가 발생하는 경우
     * e.g. DB 오류, 외부 API 연동 오류
     */
    class ServerError(
        logMessage: String,
        exception: Exception,
    ) : ServerException(
        logMessage = logMessage,
        errorCode = ERROR_CODE,
        cause = exception,
    ) {
        companion object {
            private const val ERROR_CODE = "USER.SERVER_ERROR"
        }
    }
}
