package com.example.demo.dao

import com.example.demo.model.Post
import com.example.demo.model.User
import java.util.Optional
import java.util.UUID

interface PostDao {

    fun insertPost(id: UUID,post: Post): Int
    fun insertPost(post: Post): Int{
        val id = UUID.randomUUID();
        return insertPost(id, post)
    }

    fun findById(id: UUID): Optional<Post>

    fun getAllPosts(): List<Post>

    fun updatePost(id: UUID,post: Post): Post

    fun deletePost(id: UUID): Int

}