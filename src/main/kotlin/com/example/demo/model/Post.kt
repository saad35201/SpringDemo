package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Post(
    @JsonProperty("id") val id: UUID?,
    @JsonProperty("title") var title: String,
    @JsonProperty("description") var description: String,
    @JsonProperty("comment_count", required = false) var commentCount: Double?,
    @JsonProperty("created_at" , required = false) var createdAt: Long?
)
