package example.common.exception

import org.springframework.http.HttpStatus

/**
 * Authorization exception
 * e.g.) When the user requests without login
 */
class AuthorizationException(
    message: String,
    logMessage: String,
    errorCode: String,
    cause: Exception? = null
) : BaseException(
    message = message,
    logMessage = logMessage,
    errorCode = errorCode,
//    statusCode = HttpStatus.FORBIDDEN,
    cause = cause,
)
