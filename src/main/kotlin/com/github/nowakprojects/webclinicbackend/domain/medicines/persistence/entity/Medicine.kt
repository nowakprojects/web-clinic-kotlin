package com.github.nowakprojects.webclinicbackend.domain.medicines.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class Medicine(
        @NotBlank
        var name: String,

        @ManyToOne
        var drugMaker: DrugMaker?
) : DeletableEntity() {
    constructor() : this("", null)
}