package com.github.nowakprojects.webclinicbackend.domain.errorhandling.mapper

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class ErrorCodeToHttpStatusMapper(private val httpErrorCodes: Map<ErrorCode, HttpStatus>) {
    fun mapToHttpStatus(errorCode: ErrorCode) = httpErrorCodes.getOrDefault(errorCode, HttpStatus.BAD_REQUEST)
}