package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.rest

import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service.MedicalVisitService
import com.github.nowakprojects.webclinicbackend.global.annotation.LoggedUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RequestMapping("/api/v1/medical-visit")
@RestController
class MedicalVisitController(
        private val medicalVisitService: MedicalVisitService
) {

    @GetMapping("/today")
    fun getAllTodayMedicalVisitsForLoggedDoctor(@LoggedUser loggedDoctor: User): List<MedicalVisit> {
        return medicalVisitService.findAllByDoctorEmployeeIdAndPlannedDate(loggedDoctor.id!!, LocalDate.now())
    }

    @GetMapping
    fun getAllMedicalVisitsPlannedOnSelectedDayForLoggedDoctor(
            @LoggedUser loggedDoctor: User,
            @RequestParam(required = false) day: LocalDate = LocalDate.now()): List<MedicalVisit> {
        return medicalVisitService.findAllByDoctorEmployeeIdAndPlannedDate(loggedDoctor.id!!, day)
    }
}