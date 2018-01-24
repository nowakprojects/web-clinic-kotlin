package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.repository

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository.DeletableEntityRepository
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime

//DP: Repository
@Repository
interface MedicalVisitRepository : DeletableEntityRepository<MedicalVisit> {
    fun findAllByDoctorEmployeeIdAndPlannedDate(doctorEmployeeId: Long, visitPlannedDate: LocalDate): List<MedicalVisit>
}