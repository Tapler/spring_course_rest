package com.seroevvlad.spring.rest.exception_handling

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    fun handlerException(exception: NoSuchEmployeeException): ResponseEntity<EmployeeIncorrectData>? {
        val data = EmployeeIncorrectData()
        data.info = exception.message!!
        return ResponseEntity(data, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handlerException(exception: Exception): ResponseEntity<EmployeeIncorrectData>? {
        val data = EmployeeIncorrectData()
        data.info = exception.message!!
        return ResponseEntity(data, HttpStatus.BAD_REQUEST)
    }
}