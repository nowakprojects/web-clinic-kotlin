package com.github.nowakprojects.webclinicbackend.domain.employee.mapper

import com.github.nowakprojects.webclinicbackend.domain.authentication.mapper.UserMapper
import com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto.UserInfoDto
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", uses = [UserMapper::class])
abstract class EmployeeMapper {

    fun toUserInfoDto(doctor: Doctor): UserInfoDto =
            UserInfoDto(
                    id = doctor.employee.id!!,
                    pesel = doctor.employee.pesel,
                    email = doctor.employee.email,
                    firstName = doctor.employee.firstName,
                    lastName = doctor.employee.lastName,
                    dateOfBirth = doctor.employee.dateOfBirth,
                    address = doctor.employee.address
            )
}