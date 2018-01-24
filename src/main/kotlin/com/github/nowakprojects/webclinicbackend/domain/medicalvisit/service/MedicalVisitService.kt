package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service

import com.github.nowakprojects.webclinicbackend.domain.abstraction.service.DeletableEntityService
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode.MEDICAL_VISIT_NOT_FOUND
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.repository.MedicalVisitRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class MedicalVisitService(
        repository: MedicalVisitRepository
) : DeletableEntityService<MedicalVisit, MedicalVisitRepository>(repository, MEDICAL_VISIT_NOT_FOUND) {

    fun findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate(doctorEmployeeId: Long, plannedDate: LocalDate)
            = repository.findAllByDoctorEmployeeIdAndPlannedDate(doctorEmployeeId, plannedDate)

    fun cancelMedicalVisitById(medicalVisitId: Long): MedicalVisit
            = tryToModifyNotDeletedById(medicalVisitId, { cancelled = true })

    fun startMedicalVisitById(medicalVisitId: Long): MedicalVisit
            = tryToModifyNotDeletedById(medicalVisitId, { startDateTime = LocalDateTime.now() })

    fun finishMedicalVisitById(medicalVisitId: Long): MedicalVisit
            = tryToModifyNotDeletedById(medicalVisitId, { endDateTime = LocalDateTime.now() })
}