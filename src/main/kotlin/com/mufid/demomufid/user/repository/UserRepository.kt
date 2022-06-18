package com.mufid.demomufid.user.repository

import com.mufid.demomufid.user.entity.User

interface UserRepository {
    fun getUserByName(name: String): User?
    fun getUsers(): List<User>
    fun addUser(name: String): List<User>
}