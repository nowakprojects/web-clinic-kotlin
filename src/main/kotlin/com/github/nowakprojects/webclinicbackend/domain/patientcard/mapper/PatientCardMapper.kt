package com.github.nowakprojects.webclinicbackend.domain.patientcard.mapper

import com.github.nowakprojects.webclinicbackend.domain.authentication.mapper.UserMapper
import com.github.nowakprojects.webclinicbackend.domain.patientcard.model.dto.response.PatientCardDto
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [UserMapper::class])
abstract class PatientCardMapper {

    abstract fun toPatientCardDto(patientCard: PatientCard): PatientCardDto

    abstract fun toPatientCardDtoList(patientCard: List<PatientCard>): List<PatientCardDto>
}