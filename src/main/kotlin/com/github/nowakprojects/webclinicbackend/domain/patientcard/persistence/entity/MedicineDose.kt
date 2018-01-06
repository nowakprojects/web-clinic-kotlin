package com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.BaseEntity
import com.github.nowakprojects.webclinicbackend.domain.medicines.persistence.entity.Medicine
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
data class MedicineDose(
        @OneToOne
        var medicine: Medicine,
        var dosage: String
) : BaseEntity() {

    constructor() : this(Medicine(), "")
}