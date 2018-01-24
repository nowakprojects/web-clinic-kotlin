package com.github.nowakprojects.webclinicbackend.testsample

import com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity.Doctor

class DoctorSampleFactory {
    companion object {
        //DP: Factory method
        fun createSampleDoctor(id: Long): Doctor {
            return Doctor().apply { this.id = id }
        }
    }
}