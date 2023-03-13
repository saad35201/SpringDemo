package com.example.demo.api

import com.example.demo.model.User
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional
import java.util.UUID

@RequestMapping("api/v1/user")
@RestController
class UserController @Autowired constructor(private val userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody user: User){
        userService.addUser(user)
    }

    @GetMapping
    fun getAllUsers(): List<User>{
        return userService.getAllUsers()
    }

    @GetMapping(path = ["{id}"])
    fun getUserById(@PathVariable("id") id: UUID): User{
        return userService.getUserById(id).orElse(null)
    }

    @PutMapping(path = ["{id}"])
    fun updateUser(@PathVariable("id") id: UUID,@RequestBody user: User): User{
        return userService.updateUser(id,user)
    }

}