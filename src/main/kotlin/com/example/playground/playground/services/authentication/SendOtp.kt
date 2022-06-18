package com.example.playground.playground.services.authentication



import com.example.playground.playground.services.common.BaseResponse
import com.example.playground.playground.services.common.ParameterValidationError
import com.example.playground.playground.services.utils.isPhoneNumberValid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class SendOtp {


    @PostMapping("/sendOtp", headers= ["Accept=application/json"])
    fun sendOtp(@RequestBody request:SendOtpRequest?):ResponseEntity<BaseResponse<SendOtpResponse>>{
        println(request?.phone)
        return if (request?.phone.isNullOrBlank()){
            throw ParameterValidationError(message = "شماره موبایل الزامی است!")
        }else if (request?.phone?.isPhoneNumberValid()!= true){
            throw ParameterValidationError(code = "1221","شماره موبایل معتبر نیست!")
        }else {
            //data base actions
            ResponseEntity.ok().body(BaseResponse.success(SendOtpResponse(UUID.randomUUID().toString())))
        }

    }

}