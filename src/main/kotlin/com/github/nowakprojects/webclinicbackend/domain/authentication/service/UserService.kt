package com.github.nowakprojects.webclinicbackend.domain.authentication.service

import com.github.nowakprojects.webclinicbackend.domain.abstraction.service.DeletableEntityService
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.repository.UserRepository
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException.ErrorCode.USER_NOT_FOUND
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
        repository: UserRepository
) : DeletableEntityService<User, UserRepository>(repository, USER_NOT_FOUND), UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails = tryToFindActiveByEmail(email)

    fun tryToFindActiveByEmail(email: String) = tryToFindOneByQuery { repository.findByEmailAndDeletedIsFalseAndLockedIsFalse(email) }
}