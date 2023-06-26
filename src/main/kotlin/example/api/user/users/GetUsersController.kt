package example.api.user.users

import com.fasterxml.jackson.databind.JsonMappingException
import example.api.user.UserPath
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(UserPath.users)
class GetUsersController {
    @GetMapping
    fun getUsers(
        @RequestParam("size", defaultValue = "10") size: Int,
        @RequestParam("page", defaultValue = "1") page: Int,
    ) {
        throw JsonMappingException("XXX 오류")
    }
}
