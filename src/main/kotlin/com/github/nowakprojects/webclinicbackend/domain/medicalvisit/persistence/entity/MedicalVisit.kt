package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import java.time.LocalDateTime
import java.util.Objects.isNull
import java.util.Objects.nonNull
import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
data class MedicalVisit(

        @NotNull
        @OneToOne
        var doctor: Doctor,

        @NotNull
        @OneToOne
        var patientCard: PatientCard,

        @NotNull
        var plannedDate: LocalDateTime,

        var startDate: LocalDateTime?,

        var endDate: LocalDateTime?,

        var cancelled: Boolean = false
) : DeletableEntity() {

    constructor() : this(Doctor(), PatientCard(), LocalDateTime.now(), null, null)

    fun tookPlace(): Boolean = nonNull(startDate) && nonNull(endDate)

    fun inProgress(): Boolean = nonNull(startDate) && isNull(endDate)
}