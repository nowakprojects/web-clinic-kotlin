package com.github.nowakprojects.webclinicbackend.domain.patientcard.model.dto.response

import com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity.Address
import com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto.UserInfoDto

data class PatientCardDto(
        var id: Long,
        var patient: UserInfoDto
) {
    constructor() : this(-1, UserInfoDto())
}