package com.example.playground.playground.services.common

import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


class ParameterValidationError(val code:String = "111",message:String):Exception(message)



@ControllerAdvice
class AuthAdvice{

    @ResponseBody
    @ExceptionHandler(ParameterValidationError::class)
    @ResponseStatus(HttpStatus.OK)
    fun parameterValidationErrorHandler(exception:ParameterValidationError):ResponseEntity<BaseResponse<Nothing>>{
        return ResponseEntity.ok().body(BaseResponse(exception.code,exception.message?:"",null))
    }
}

