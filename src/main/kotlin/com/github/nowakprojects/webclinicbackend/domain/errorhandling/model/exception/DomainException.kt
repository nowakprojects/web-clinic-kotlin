package com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception


class DomainException
private constructor(val errorCode: ErrorCode, cause: Throwable?) : RuntimeException(errorCode.name, cause) {

    enum class ErrorCode {
        USER_NOT_FOUND,
        MEDICAL_VISIT_NOT_FOUND
    }

    companion object {
        fun of(errorCode: ErrorCode) = DomainException(errorCode, null)

        fun of(errorCode: ErrorCode, cause: Throwable) = DomainException(errorCode, cause)
    }
}