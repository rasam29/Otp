package com.example.playground.playground.services.authentication


data class SendOtpRequest(
    val phone:String?
)
data class SendOtpResponse(
    val uuid:String
)
data class ValidateRequest(
    val phone: String?,
    val code:String?,
    val uuid:String?
)


data class ValidateResponse(
    val token:String
)

