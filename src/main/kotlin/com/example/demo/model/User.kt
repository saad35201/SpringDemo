package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class User(
    @JsonProperty("id") val id: UUID?,
    @JsonProperty("firstName") var firstName: String,
    @JsonProperty("lastName") var lastName: String,
    @JsonProperty("fullName", required = false) var fullName: String?,
    @JsonProperty("email") var email: String,
    @JsonProperty("dob") var dob: Long,
    @JsonProperty("phone") var phone: String,
    @JsonProperty("country") var country: String
)
