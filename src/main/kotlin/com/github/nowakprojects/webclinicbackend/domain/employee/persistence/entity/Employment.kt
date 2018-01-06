package com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.BaseEntity
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.JobPosition
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.WorkTime
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

const val DEFAULT_EMPLOYMENT_PERIOD_MONTHS = 3L
const val DEFAULT_EMPLOYMENT_SALARY = 3000L

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Employment(

        @NotNull
        @ManyToOne
        var employee: User,

        @Enumerated(EnumType.STRING)
        @NotNull
        var jobPosition: JobPosition = JobPosition.DOCTOR,

        @Enumerated(EnumType.STRING)
        @NotNull
        var workTime: WorkTime = WorkTime.FULL_TIME,

        @NotNull
        var salary: Long = DEFAULT_EMPLOYMENT_SALARY,

        @NotNull
        var startDate: LocalDate = LocalDate.now(),

        @NotNull
        var endDate: LocalDate = LocalDate.now().plusMonths(DEFAULT_EMPLOYMENT_PERIOD_MONTHS)
) : BaseEntity()
