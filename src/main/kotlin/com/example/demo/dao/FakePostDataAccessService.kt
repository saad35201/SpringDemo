package com.example.demo.dao

import com.example.demo.model.Post
import com.example.demo.model.User
import org.springframework.stereotype.Repository
import java.util.*
import java.util.stream.Stream

@Repository("fakePostDao")
class FakePostDataAccessService : PostDao {

    private val DB = ArrayList<Post>()
    override fun insertPost(id: UUID, post: Post): Int {
        DB.add(
            Post(
                id = id,
                title = post.title,
                description = post.description,
                commentCount = post.commentCount,
                createdAt = post.createdAt
            )
        )
        return 1
    }

    override fun findById(id: UUID): Optional<Post> {
        return DB.stream().filter { it.id!! == id }.findFirst()
    }

    override fun getAllPosts(): List<Post> {
        return DB
    }

    override fun updatePost(id: UUID, post: Post): Post {
        val postToUpdate = findById(id)
        val index = DB.indexOf(postToUpdate.get())
        DB[index].title = post.title
        DB[index].description = post.description
        DB[index].commentCount = post.commentCount
        DB[index].createdAt = post.createdAt
        return DB[index]
    }

    override fun deletePost(id: UUID): Int {
        val post = findById(id)
        if (post.isEmpty) {
            return 0
        }
        DB.remove(post.get())
        return 1
    }


}