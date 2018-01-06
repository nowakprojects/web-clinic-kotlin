package com.github.nowakprojects.webclinicbackend.domain.abstraction.service

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.repository.DeletableEntityRepository
import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException

abstract class DeletableEntityService<T : DeletableEntity, R : DeletableEntityRepository<T>>(
        protected val repository: R,
        protected val entityNotFoundErrorCode: DomainException.ErrorCode
) {

    protected fun tryToModifyNotDeletedById(id: Long, apply: T.() -> Unit) =
            repository.save(tryToFindNotDeletedById(id).apply(apply))

    fun tryToFindNotDeletedById(id: Long) = tryToFindOneByQuery { repository.findOneByIdAndDeletedIsFalse(id) }

    protected fun tryToFindOneByQuery(query: () -> T?): T = query() ?: throw DomainException.of(entityNotFoundErrorCode)
}