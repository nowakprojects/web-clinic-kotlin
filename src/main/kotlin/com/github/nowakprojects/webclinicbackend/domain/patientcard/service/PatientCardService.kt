package com.github.nowakprojects.webclinicbackend.domain.patientcard.service

import com.github.nowakprojects.webclinicbackend.domain.abstraction.service.DeletableEntityService
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode.PATIENT_CARD_NOT_FOUND
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.repository.PatientCardRepository
import org.springframework.stereotype.Service

@Service
class PatientCardService(repository: PatientCardRepository)
    : DeletableEntityService<PatientCard, PatientCardRepository>(repository, PATIENT_CARD_NOT_FOUND) {


    fun tryToFindPatientCardByPatientId(patientId: Long) =
            tryToFindNotDeletedById(patientId)

    fun findAllPatientCard() = repository.findAllByDeletedIsFalse()
}