package com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseEntityRepository<T : BaseEntity> : JpaRepository<T, Long> {
}