package example.api

import example.common.exception.AuthorizationException
import example.common.exception.BaseException
import example.common.exception.ClientException
import example.common.exception.ServerException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        return this.handleBaseException(
            ServerException(
                message = "오류가 발생했습니다. 다시 시도해주세요.",
                logMessage = "Unexpected exception occurred: $exception",
                errorCode = "ERROR",
                cause = exception,
            )
        )
    }

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(exception: BaseException): ResponseEntity<ErrorResponse> {
        this.logException(exception)
        return this.toResponse(exception)
    }

    private fun logException(exception: BaseException) {
        when (exception) {
            is ClientException,
            is AuthorizationException ->
                this.logger.warn(exception.logMessage, exception.cause)

            is ServerException ->
                this.logger.error(exception.logMessage, exception.cause)
        }
    }

    fun toResponse(exception: BaseException): ResponseEntity<ErrorResponse> {
        val statusCode = when (exception) {
            is ClientException -> HttpStatus.BAD_REQUEST
            is AuthorizationException -> HttpStatus.FORBIDDEN
            is ServerException -> HttpStatus.INTERNAL_SERVER_ERROR
        }

        return ResponseEntity
//            .status(exception.statusCode)
            .status(statusCode)
            .body(
                ErrorResponse(
                    code = exception.errorCode,
                    message = exception.message,
                )
            )
    }
}
