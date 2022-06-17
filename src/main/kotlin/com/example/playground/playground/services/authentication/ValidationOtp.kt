package com.example.playground.playground.services.authentication


import com.example.playground.playground.services.utils.BaseResponse
import com.example.playground.playground.services.utils.INAVILD_DATA
import com.example.playground.playground.services.utils.PHONE_NUMBER_NOT_VALID
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
class ValidationOtp {

    @PostMapping("/validateOtp")
    fun validateOtp(@RequestParam("code")code:String?,@RequestParam("uuid") uuid:String?):ResponseEntity<BaseResponse<ValidateResponse>>{
        return if (code.isNullOrBlank() || uuid.isNullOrBlank()) {
            ResponseEntity.ok().body(BaseResponse(INAVILD_DATA, "اطلاعات ورودی نادرست است!", null))

        }else{
            ResponseEntity.ok().body(BaseResponse(PHONE_NUMBER_NOT_VALID, "احراز هویت با موفقیت انجام شد!",
                ValidateResponse(UUID.randomUUID().toString())
            ))

        }

    }

}