package com.example.demo.api

import com.example.demo.model.Post
import com.example.demo.model.User
import com.example.demo.service.PostService
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

@RequestMapping("api/v1/post")
@RestController
class PostController @Autowired constructor(private val postService: PostService) {

    @PostMapping
    fun createPost(@RequestBody post: Post){
        postService.createPost(post = post)
    }

    @GetMapping
    fun getAllPosts(): List<Post>{
        return postService.getAllPosts()
    }

    @GetMapping(path = ["{id}"])
    fun findById(@PathVariable("id") id: UUID): Post{
        return postService.findById(id).orElse(null)
    }

    @PutMapping(path = ["{id}"])
    fun updatePost(@PathVariable("id") id: UUID,@RequestBody post: Post): Post{
        return postService.updatePost(id = id, post = post)
    }

}