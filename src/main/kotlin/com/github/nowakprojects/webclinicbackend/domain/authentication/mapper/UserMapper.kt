package com.github.nowakprojects.webclinicbackend.domain.authentication.mapper

import com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto.UserInfoDto
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper {


    fun toUserInfoDto(user: User): UserInfoDto {
        return UserInfoDto(
                user.id!!,
                user.pesel,
                user.email,
                user.firstName,
                user.lastName,
                user.dateOfBirth,
                user.address
        )
    }
}