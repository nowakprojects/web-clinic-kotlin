package com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.repository

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository.DeletableEntityRepository
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : DeletableEntityRepository<User> {

    fun findByEmailAndDeletedIsFalseAndLockedIsFalse(email: String): User?
}