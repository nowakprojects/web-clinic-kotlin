package com.github.nowakprojects.webclinicbackend.domain.space.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import javax.persistence.Entity

@Entity
data class MedicalRoom(
        var number: String
) : DeletableEntity() {
    constructor() : this("")
}