package com.github.nowakprojects.webclinicbackend.global.configuration

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode.USER_NOT_FOUND
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus

@Configuration
class ErrorHandlingConfig {

    @Bean
    fun errorCodeToHttpStatusMap(): Map<ErrorCode, HttpStatus> {
        return mapOf(
                USER_NOT_FOUND to HttpStatus.NOT_FOUND
        )


    }

}