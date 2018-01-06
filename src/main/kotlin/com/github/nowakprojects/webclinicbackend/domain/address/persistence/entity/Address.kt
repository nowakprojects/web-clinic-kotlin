package com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.BaseEntity
import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Address(
        @NotBlank
        var city: String,

        @NotBlank
        var street: String,

        var country: String,

        @NotBlank
        var number: String,

        @NotBlank
        @Column(length = 6)
        var zipCode: String
) : BaseEntity() {

    constructor() : this("", "", "", "", "")
}