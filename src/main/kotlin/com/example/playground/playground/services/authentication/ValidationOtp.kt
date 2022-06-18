package com.example.playground.playground.services.authentication



import com.example.playground.playground.services.common.BaseResponse
import com.example.playground.playground.services.common.PHONE_NUMBER_NOT_VALID
import com.example.playground.playground.services.common.ParameterValidationError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
class ValidationOtp {

    @PostMapping("/validateOtp",headers= ["Accept=application/json"])
    fun validateOtp(@RequestBody request:ValidateRequest):ResponseEntity<BaseResponse<ValidateResponse>>{
        return if (request.code.isNullOrBlank() || request.uuid.isNullOrBlank()) {
            throw ParameterValidationError("", message = "اطلاعات ورودی نادرست!")

        }else{
            val generatedUuid = UUID.randomUUID().toString()
            ResponseEntity.ok().body(BaseResponse(PHONE_NUMBER_NOT_VALID, "احراز هویت با موفقیت انجام شد!",
                ValidateResponse(generatedUuid)
            ))

        }

    }

}