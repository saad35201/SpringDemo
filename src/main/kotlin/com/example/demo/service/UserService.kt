package com.example.demo.service

import com.example.demo.dao.UserDao
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
class UserService @Autowired constructor(
    @Qualifier("fakeDao") private val userDao: UserDao
) {

    fun addUser(user: User): Int {
        return userDao.insertUser(user)
    }

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    fun getUserById(id: UUID): Optional<User>{
        return userDao.getUserById(id)
    }

    fun updateUser(id: UUID,user: User): User{
        return userDao.updateUser(id,user)
    }

}