package com.example.playground.playground.services.user

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long,
    val phoneNumber: String,
    val uuid:String,
    val grantedAuthorities:List<GrantedAuthority>
    )