package com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity

import java.time.ZonedDateTime
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.PreUpdate
import javax.validation.constraints.NotNull

//TODO: Add JPA Auditing with createdBy
@MappedSuperclass
abstract class BaseEntity(
        @Id
        @GeneratedValue
        var id: Long? = null,

        @NotNull
        var createdDate: ZonedDateTime = ZonedDateTime.now(),

        var lastModifiedDate: ZonedDateTime? = null
) {

    fun isModified(): Boolean {
        return lastModifiedDate != null && lastModifiedDate != createdDate
    }

    @PreUpdate
    fun preUpdate() {
        setLastModifiedDateToPresent()
    }

    private fun setLastModifiedDateToPresent() {
        lastModifiedDate = ZonedDateTime.now()
    }

}