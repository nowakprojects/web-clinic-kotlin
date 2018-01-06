package com.github.nowakprojects.webclinicbackend.domain.errorhandling.rest

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.mapper.ErrorCodeToHttpStatusMapper
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.dto.response.ErrorDto
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionController
constructor(val errorCodeToHttpStatusMapper: ErrorCodeToHttpStatusMapper) {

    @ExceptionHandler(DomainException::class)
    fun processDomainException(domainException: DomainException): ResponseEntity<ErrorDto> {
        val errorCode = domainException.errorCode
        return ResponseEntity
                .status(errorCodeToHttpStatusMapper.mapToHttpStatus(errorCode))
                .body(ErrorDto(errorCode))
    }

}