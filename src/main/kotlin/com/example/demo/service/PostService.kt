package com.example.demo.service

import com.example.demo.dao.PostDao
import com.example.demo.dao.UserDao
import com.example.demo.model.Post
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
class PostService @Autowired constructor(
    @Qualifier("fakePostDao") private val postDao: PostDao
) {

    fun createPost(post: Post): Int {
        return postDao.insertPost(post = post)
    }

    fun getAllPosts(): List<Post> {
        return postDao.getAllPosts()
    }

    fun findById(id: UUID): Optional<Post>{
        return postDao.findById(id = id)
    }

    fun updatePost(id: UUID,post: Post): Post{
        return postDao.updatePost(id = id, post = post)
    }

}