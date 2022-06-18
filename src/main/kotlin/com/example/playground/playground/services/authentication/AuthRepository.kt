package com.example.playground.playground.services.authentication

import com.example.playground.playground.services.user.UserEntity
import org.springframework.data.repository.CrudRepository


interface AuthRepository :CrudRepository<UserEntity,String> {


}