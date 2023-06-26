package example.common.exception

import org.springframework.http.HttpStatus

sealed class BaseException(
    override val message: String, // 외부로 노출되는 메세지
    val logMessage: String, // 내부 로깅용 메세지
    val errorCode: String, // exception type
//    val statusCode: HttpStatus,
    override val cause: Exception? = null
) : RuntimeException()
