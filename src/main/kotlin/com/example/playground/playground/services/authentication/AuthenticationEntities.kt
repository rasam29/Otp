package com.example.playground.playground.services.authentication

data class ValidateResponse(
    val token:String
)

data class SendOtpResponse(
    val uuid:String
)