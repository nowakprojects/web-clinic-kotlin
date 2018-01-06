package com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity

import java.time.ZonedDateTime
import javax.persistence.MappedSuperclass
import javax.validation.constraints.NotNull

@MappedSuperclass
abstract class DeletableEntity(
        createdDate: ZonedDateTime = ZonedDateTime.now(),
        lastModifiedDate: ZonedDateTime? = null,
        deleted: Boolean = false
) : BaseEntity(createdDate = createdDate, lastModifiedDate = lastModifiedDate) {

    @NotNull
    var deleted: Boolean = false
        set(value) {
            field = value
            if (deleted) {
                lastDeletedDate = ZonedDateTime.now()
            }
        }

    var lastDeletedDate: ZonedDateTime? = null
        private set

    init {
        this.deleted = deleted;
    }
}
