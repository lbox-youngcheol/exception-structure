package example.common.exception

import org.springframework.http.HttpStatus

/**
 * Client-side exception
 * e.g.) Value is not valid, Duplicated request
 */
open class ClientException(
    message: String,
    logMessage: String,
    errorCode: String,
    cause: Exception? = null
) : BaseException(
    message = message,
    logMessage = logMessage,
    errorCode = errorCode,
//    statusCode = HttpStatus.BAD_REQUEST,
    cause = cause,
)
