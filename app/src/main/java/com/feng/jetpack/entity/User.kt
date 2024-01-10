package com.feng.jetpack.entity

data class User(var name: String, var age: Int)

fun main() {
    val user = User("wang", 3).apply {
        name = "jing"
    }
    print(user)
}