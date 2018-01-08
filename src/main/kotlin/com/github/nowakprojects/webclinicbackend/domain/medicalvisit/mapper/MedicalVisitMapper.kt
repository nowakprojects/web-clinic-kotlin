package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.mapper

import com.github.nowakprojects.webclinicbackend.domain.employee.mapper.EmployeeMapper
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.model.dto.response.MedicalVisitBasicInfoDto
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.patientcard.mapper.PatientCardMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring", uses = [PatientCardMapper::class, EmployeeMapper::class])
abstract class MedicalVisitMapper {

    @Mappings(
            Mapping(target = "tookPlace", expression = "java(arg0.tookPlace())"),
            Mapping(target = "inProgress", expression = "java(arg0.inProgress())")
    )
    abstract fun toMedicalVisitBasicInfoDto(medicalVisit: MedicalVisit): MedicalVisitBasicInfoDto

    abstract fun toMedicalVisitBasicInfoDtoList(medicalVisitList: List<MedicalVisit>): List<MedicalVisitBasicInfoDto>
}