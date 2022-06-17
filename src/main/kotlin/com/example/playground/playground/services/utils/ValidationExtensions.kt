package com.example.playground.playground.services.utils

fun String.isPhoneNumberValid(): Boolean {
    if (length == 11) {
        return !isNullOrEmpty() && startsWith("09")
    } else if (length == 10) {
        return !isNullOrEmpty() && startsWith("9")
    }

    return false
}