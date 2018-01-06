package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.model.dto.response

import com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto.UserInfoDto
import com.github.nowakprojects.webclinicbackend.domain.patientcard.model.dto.response.PatientCardDto
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import javax.validation.constraints.NotNull

data class MedicalVisitBasicInfoDto(
        var doctor: UserInfoDto,
        var patientCard: PatientCardDto,
        var plannedDate: LocalDate,
        var plannedTime: LocalTime,
        var startDateTime: LocalDateTime?,
        var endDateTime: LocalDateTime?,
        var cancelled: Boolean = false,
        var tookPlace: Boolean = false,
        var inProgress: Boolean = false
) {
    constructor() : this(UserInfoDto(), PatientCardDto(), LocalDate.now(), LocalTime.now(), null, null)
}