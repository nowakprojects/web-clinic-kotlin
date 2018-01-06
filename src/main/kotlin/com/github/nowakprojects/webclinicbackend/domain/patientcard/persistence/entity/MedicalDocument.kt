package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass
import javax.validation.constraints.NotNull

@MappedSuperclass
abstract class MedicalDocument(
        @NotNull
        @ManyToOne
        var patientCard: PatientCard,

        @NotNull
        @ManyToOne
        var createdBy: Doctor
) : DeletableEntity() {
    constructor() : this(PatientCard(), Doctor())
}