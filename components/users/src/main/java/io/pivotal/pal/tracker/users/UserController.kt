package io.pivotal.pal.tracker.users

import io.pivotal.pal.tracker.users.data.UserDataGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/users"])
class UserController(private val gateway: UserDataGateway) {

    @GetMapping(value = ["/{userId}"])
    fun show(@PathVariable userId: Long): UserInfo? {
        val (id, name) = gateway.find(userId) ?: return null
        return UserInfo(id, name, "user info")
    }
}