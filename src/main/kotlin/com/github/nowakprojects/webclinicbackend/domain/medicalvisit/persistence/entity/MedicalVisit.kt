package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Objects.isNull
import java.util.Objects.nonNull
import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

//TODO: Add room field
@Entity
data class MedicalVisit(

        @NotNull
        @OneToOne
        var doctor: Doctor,

        @NotNull
        @OneToOne
        var patientCard: PatientCard,

        @NotNull
        var plannedDate: LocalDate,

        @NotNull
        var plannedTime: LocalTime,

        var startDateTime: LocalDateTime?,

        var endDateTime: LocalDateTime?,

        var cancelled: Boolean = false
) : DeletableEntity() {

    constructor() : this(Doctor(), PatientCard(), LocalDate.now(), LocalTime.now(), null, null)

    fun tookPlace(): Boolean = nonNull(startDateTime) && nonNull(endDateTime)

    fun inProgress(): Boolean = nonNull(startDateTime) && isNull(endDateTime)

    class Builder {
        var doctor: Doctor? = null
            private set

        var patientCard: PatientCard? = null
            private set

        var plannedDate: LocalDate? = null
            private set

        var plannedTime: LocalTime? = null
            private set

        var startDateTime: LocalDateTime? = null
            private set

        var endDateTime: LocalDateTime? = null
            private set

        var cancelled: Boolean = false
            private set

        fun doctor(doctor: Doctor) = apply {this.doctor = doctor}

        fun patientCard(patientCard: PatientCard) = apply {this.patientCard = patientCard}

        fun plannedDate(plannedDate: LocalDate) = apply {this.plannedDate = plannedDate}

        fun plannedTime(plannedTime: LocalTime) = apply {this.plannedTime = plannedTime}

        fun startDateTime(startDateTime: LocalDateTime) = apply {this.startDateTime = startDateTime}

        fun endDateTime(endDateTime: LocalDateTime) = apply {this.endDateTime = endDateTime}

        fun cancelled(cancelled: Boolean) = apply {this.cancelled = cancelled}

        fun build() = MedicalVisit(doctor!!,patientCard!!,plannedDate!!,plannedTime!!,startDateTime, endDateTime, cancelled)
    }
}