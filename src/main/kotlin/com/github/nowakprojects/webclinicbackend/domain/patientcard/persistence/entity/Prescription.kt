package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.OneToMany

const val PRESCRIPTION_NOTES_MAX_LENGTH = 255;

@Entity
data class Prescription(
        @Length(max = PRESCRIPTION_NOTES_MAX_LENGTH)
        var notes: String?,

        @OneToMany
        var prescribedMedicines: List<MedicineDose> = emptyList()
) : MedicalDocument() {

    constructor(notes: String, prescribedMedicines: List<MedicineDose>, patientCard: PatientCard, createdBy: Doctor)
            : this(notes, prescribedMedicines) {
        this.patientCard = patientCard
        this.createdBy = createdBy
    }
}