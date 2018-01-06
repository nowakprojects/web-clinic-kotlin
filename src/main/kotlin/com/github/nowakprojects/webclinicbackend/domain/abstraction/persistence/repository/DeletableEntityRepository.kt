package com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface DeletableEntityRepository<T : DeletableEntity> : BaseEntityRepository<T> {

    fun findOneById(id: Long): T?

    fun findOneByIdAndDeletedIsFalse(id: Long): T?

    fun findAllByDeletedIsFalse(): List<T>

    override fun delete(entity: T) {
        entity.deleted = false
        save(entity)
    }

}