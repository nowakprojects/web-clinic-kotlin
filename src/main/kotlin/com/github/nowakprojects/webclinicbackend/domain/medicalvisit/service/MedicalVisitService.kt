package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service

import com.github.nowakprojects.webclinicbackend.domain.abstraction.service.DeletableEntityService
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode.MEDICAL_VISIT_NOT_FOUND
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.repository.MedicalVisitRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MedicalVisitService(
        repository: MedicalVisitRepository
) : DeletableEntityService<MedicalVisit, MedicalVisitRepository>(repository, MEDICAL_VISIT_NOT_FOUND) {

    fun findAllByDoctorEmployeeIdAndPlannedDate(doctorEmployeeId: Long, plannedDate: LocalDateTime)
            = repository.findAllByDoctorEmployeeIdAndPlannedDate(doctorEmployeeId, plannedDate)

}