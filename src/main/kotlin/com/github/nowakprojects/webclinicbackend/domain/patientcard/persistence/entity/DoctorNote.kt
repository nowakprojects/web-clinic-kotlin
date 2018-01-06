package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import com.github.nowakprojects.webclinicbackend.domain.patientcard.model.enumeration.DoctorNoteType
import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotNull

@Entity
data class DoctorNote(

        @NotBlank
        var content: String,

        @NotNull
        @Enumerated(EnumType.STRING)
        var doctorNoteType: DoctorNoteType
) : MedicalDocument() {

    constructor(content: String, doctorNoteType: DoctorNoteType, patientCard: PatientCard, createdBy: Doctor)
            : this(content, doctorNoteType) {
        this.patientCard = patientCard
        this.createdBy = createdBy
    }
}