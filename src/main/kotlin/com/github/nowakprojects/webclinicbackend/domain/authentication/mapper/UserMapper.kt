package com.github.nowakprojects.webclinicbackend.domain.authentication.mapper

import com.github.nowakprojects.webclinicbackend.domain.authentication.model.dto.UserInfoDto
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
abstract class UserMapper {

    abstract fun toUserInfoDto(user: User): UserInfoDto
}