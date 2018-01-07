package com.github.nowakprojects.webclinicbackend.domain.patientcard.rest

import com.github.nowakprojects.webclinicbackend.domain.patientcard.mapper.PatientCardMapper
import com.github.nowakprojects.webclinicbackend.domain.patientcard.service.PatientCardService
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/patient-card")
@RestController
class PatientCardController(
        private val patientCardService: PatientCardService,
        private val patientCardMapper: PatientCardMapper
) {

    @GetMapping
    fun getAllPatientCard()
            = patientCardMapper.toPatientCardDtoList(patientCardService.findAllPatientCard())

    @GetMapping("/{patientId}")
    fun getPatientCardByPatientId(@PathVariable patientId: Long)
            = patientCardMapper.toPatientCardDto(patientCardService.tryToFindPatientCardByPatientId(patientId))


}