package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.rest

import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.mapper.MedicalVisitMapper
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service.MedicalVisitService
import com.github.nowakprojects.webclinicbackend.global.annotation.LoggedUser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("/api/v1/medical-visit")
@RestController
class MedicalVisitController(
        private val medicalVisitService: MedicalVisitService,
        private val medicalVisitMapper: MedicalVisitMapper
) {

    @GetMapping("/today")
    fun getAllTodayMedicalVisitsForLoggedDoctor(@LoggedUser loggedDoctor: User)
            = getAllMedicalVisitsPlannedOnSelectedDayForLoggedDoctor(loggedDoctor)


    @GetMapping
    fun getAllMedicalVisitsPlannedOnSelectedDayForLoggedDoctor(
            @LoggedUser loggedDoctor: User,
            @RequestParam(required = false) day: LocalDate = LocalDate.now())
            = medicalVisitMapper.toMedicalVisitBasicInfoDtoList(medicalVisitService.findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate(loggedDoctor.id!!, day))

    @GetMapping("/{medicalVisitId}")
    fun getMedicalVisitById(@PathVariable medicalVisitId: Long)
            = medicalVisitMapper.toMedicalVisitBasicInfoDto(medicalVisitService.tryToFindNotDeletedById(medicalVisitId))

    @PostMapping("cancel/{medicalVisitId}")
    fun cancelMedicalVisitById(@PathVariable medicalVisitId: Long) =
        medicalVisitMapper.toMedicalVisitBasicInfoDto(medicalVisitService.cancelMedicalVisitById(medicalVisitId))


    @PostMapping("/start/{medicalVisitId}")
    fun startMedicalVisitById(@PathVariable medicalVisitId: Long) =
        medicalVisitMapper.toMedicalVisitBasicInfoDto(medicalVisitService.startMedicalVisitById(medicalVisitId))


    @PostMapping("/finish/{medicalVisitId}")
    fun finishMedicalVisitById(@PathVariable medicalVisitId: Long) =
            medicalVisitMapper.toMedicalVisitBasicInfoDto(medicalVisitService.finishMedicalVisitById(medicalVisitId))

}