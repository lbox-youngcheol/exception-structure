package example.api.user.users

import example.domain.user.domain.UserException
import example.api.user.UserPath
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.SQLException

@RestController
@RequestMapping(UserPath.users)
class CreateUserController {

    @PostMapping
    fun createUser() {
        throw UserException.ServerError(logMessage = "유저 DB 오류", exception = SQLException("SQL ERROR"))
    }
}
