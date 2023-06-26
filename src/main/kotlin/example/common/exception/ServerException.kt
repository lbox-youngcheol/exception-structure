package example.common.exception

import org.springframework.http.HttpStatus

/**
 * Server-side exception
 * e.g.) DB connection error, Unhandled internal exception
 */
open class ServerException(
    message: String = "서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요.", // 필요한 경우 overwrite
    logMessage: String,
    errorCode: String,
    override val cause: Exception,
) : BaseException(
    message = message,
    logMessage = logMessage,
    errorCode = errorCode,
//    statusCode = HttpStatus.INTERNAL_SERVER_ERROR,
    cause = cause,
)
