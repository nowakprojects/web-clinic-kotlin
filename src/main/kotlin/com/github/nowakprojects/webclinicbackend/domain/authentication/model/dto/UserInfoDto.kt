package com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto

import com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity.Address
import java.time.LocalDate

data class UserInfoDto(
        val id: Long,
        val pesel: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val dateOfBirth: LocalDate?,
        val address: Address?
) {
    constructor() : this(-1, "", "", "", "", null, null)
}