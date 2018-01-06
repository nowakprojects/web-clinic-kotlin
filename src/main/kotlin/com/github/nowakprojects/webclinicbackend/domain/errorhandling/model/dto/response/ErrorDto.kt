package com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.dto.response

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode

data class ErrorDto(val errorCode: ErrorCode)