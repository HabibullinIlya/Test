package xyz.ilyaxabibullin.wherebackend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import xyz.ilyaxabibullin.wherebackend.entity.User
import java.util.concurrent.atomic.AtomicInteger

@RestController
class UserController {

    @GetMapping("/user/{id}")
    fun user(@PathVariable("id") id: Int): User {
        val user = User()
        user.id = id
        user.nickname = "Nagibator228"
        user.geo = "hello from webhook i am on the way to ci/cd"
        return user
    }

    @GetMapping("/users")
    fun users():List<User>{
        var array = listOf(User(1,"nagibator228","online"),
                User(2,"chupik","online"),
                User(3,"hz","online"),
                User(4,"chel", "offline"));
        return array
    }

}