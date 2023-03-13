package com.example.demo.dao

import com.example.demo.model.User
import org.springframework.stereotype.Repository
import java.util.*
import java.util.stream.Stream

@Repository("fakeDao")
class FakeUserDataAccessService : UserDao {

    private val DB = ArrayList<User>()

    override fun insertUser(id: UUID, user: User): Int {
        DB.add(
            User(
                id = id,
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                dob = user.dob,
                fullName = "${user.firstName} ${user.lastName}",
                phone = user.phone,
                country = user.country
            )
        )
        return 1
    }

    override fun getUserById(id: UUID): Optional<User> {
        return DB.stream().filter { it.id!! == id }.findFirst()
    }

    override fun getAllUsers(): List<User> {
        return DB
    }

    override fun updateUser(id: UUID, user: User): User {
        val userToUpdate = getUserById(id)
        val index = DB.indexOf(userToUpdate.get())
        DB[index].email = user.email
        DB[index].firstName = user.firstName
        DB[index].lastName = user.lastName
        return DB[index]
    }

    override fun deleteUser(id: UUID): Int {
        val user = getUserById(id)
        if (user.isEmpty) {
            return 0
        }
        DB.remove(user.get())
        return 1
    }


}