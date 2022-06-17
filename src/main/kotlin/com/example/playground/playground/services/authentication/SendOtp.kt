package com.example.playground.playground.services.authentication


import com.example.playground.playground.services.utils.BaseResponse
import com.example.playground.playground.services.utils.PHONE_NUMBER_NOT_VALID
import com.example.playground.playground.services.utils.isPhoneNumberValid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class SendOtp {


    @PostMapping("/sendOtp")
    fun sendOtp(@RequestParam("phone")phoneNumber:String?):ResponseEntity<BaseResponse<SendOtpResponse>>{
        return if (phoneNumber.isNullOrBlank()){
            ResponseEntity.ok().body(BaseResponse(PHONE_NUMBER_NOT_VALID, "ورود شماره ی همراه الزامی است!",null))
        }else if (!phoneNumber.isPhoneNumberValid()){
            ResponseEntity.ok().body(BaseResponse(PHONE_NUMBER_NOT_VALID,"شماره همراه معتبر نمیباشد!",null))
        }else {
            //data base actions
            ResponseEntity.ok().body(BaseResponse.success(SendOtpResponse(UUID.randomUUID().toString())))
        }

    }

}