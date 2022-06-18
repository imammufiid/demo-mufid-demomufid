package com.mufid.demomufid.user.repository

import com.mongodb.client.MongoCollection
import com.mufid.demomufid.database.DatabaseComponent
import com.mufid.demomufid.user.entity.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.IllegalStateException

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("user").getCollection()

    override fun getUserByName(name: String): User? {
        return userCollection().findOne(User::name eq name)
    }

    override fun getUsers(): List<User> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String): List<User> {
        val insert = userCollection().insertOne(User(name = name))

        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("Fail inserted")
        }
    }
}