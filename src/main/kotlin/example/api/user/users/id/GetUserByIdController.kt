package example.api.user.users.id

import example.domain.user.domain.UserException
import example.api.user.UserPath
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(UserPath.users)
class GetUserByIdController {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long) {
        throw UserException.NotFound(userId = id)
    }
}
