package com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto

import com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity.Address
import java.time.LocalDate

data class UserInfoDto(
        var id: Long,
        var pesel: String,
        var email: String,
        var firstName: String,
        var lastName: String,
        var dateOfBirth: LocalDate?,
        var address: Address?
) {
    constructor() : this(-1, "", "", "", "", null, null)
}