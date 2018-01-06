package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Employment
import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Registrar
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
data class PatientCard(

        @NotNull
        @OneToOne
        var patient: User,

        @NotNull
        @ManyToOne
        var createdBy: Employment
) : DeletableEntity() {
    constructor() : this(User(), Registrar())
}