package com.example.demo.dao

import com.example.demo.model.User
import java.util.Optional
import java.util.UUID

interface UserDao {

    fun insertUser(id: UUID,user: User): Int

    fun insertUser(user: User): Int{
        val id = UUID.randomUUID();
        return insertUser(id, user)
    }

    fun getUserById(id: UUID): Optional<User>

    fun getAllUsers(): List<User>

    fun updateUser(id: UUID,user: User): User

    fun deleteUser(id: UUID): Int

}