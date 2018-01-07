package com.github.nowakprojects.webclinicbackend.testsample

import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import java.time.LocalDate

class MedicalVisitSampleFactory {

    companion object {
        fun createSampleTodayMedicalVisit(id: Long): MedicalVisit {
            return MedicalVisit().apply { this.id = id }
        }

        fun createSampleTodayMedicalVisit(id: Long, patientCard: PatientCard, doctor: Doctor): MedicalVisit {
            val medicalVisit = MedicalVisit()
            medicalVisit.id = id
            medicalVisit.doctor = doctor
            medicalVisit.patientCard = patientCard
            medicalVisit.plannedDate = LocalDate.now()
            return medicalVisit;
        }
    }

}