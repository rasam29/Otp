package com.example.playground.playground.services.common



data class BaseResponse<T> (
    val code:String,
    val message:String,
    val content:T?
){
    companion object{
        fun <T> success(content:T) = BaseResponse("000","با موفقیت انجام شد!",content)
    }
}

const val SUCCESS_CODE = "000"
const val PHONE_NUMBER_NOT_VALID = "010"
const val INAVILD_DATA = "020"

