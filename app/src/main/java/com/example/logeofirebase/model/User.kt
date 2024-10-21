package com.example.logeofirebase.model

data class User(
    val name: String,
    val email: String,
    val userId: String,
    ){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "name" to name,
            "email" to email,
            "userId" to userId,
        )
    }
}
