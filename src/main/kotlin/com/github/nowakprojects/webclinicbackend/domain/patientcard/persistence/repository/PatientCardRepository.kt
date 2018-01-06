package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.repository

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository.DeletableEntityRepository
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import org.springframework.stereotype.Repository

@Repository
interface PatientCardRepository: DeletableEntityRepository<PatientCard> {

    fun findByPatientId(userId: Long)
}