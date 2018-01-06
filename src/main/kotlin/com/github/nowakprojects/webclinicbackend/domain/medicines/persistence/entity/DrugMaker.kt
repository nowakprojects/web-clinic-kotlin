package com.github.nowakprojects.webclinicbackend.domain.medicines.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity.Address
import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
data class DrugMaker(
        @NotNull
        var name: String,

        @OneToOne
        var address: Address?
) : DeletableEntity() {
    constructor() : this("", null)
}