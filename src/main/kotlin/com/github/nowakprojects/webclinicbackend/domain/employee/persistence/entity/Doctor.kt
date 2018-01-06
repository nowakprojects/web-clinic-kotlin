package com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.JobPosition
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.WorkTime
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotBlank
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity

const val DOCTOR_COLUMN_PWZ_NUMBER_LENGTH = 6

@Entity
class Doctor(

        employee: User = User(),
        workTime: WorkTime = WorkTime.FULL_TIME,
        salary: Long = DEFAULT_EMPLOYMENT_SALARY,
        employmentStartDate: LocalDate = LocalDate.now(),
        employmentEndDate: LocalDate = LocalDate.now().plusMonths(DEFAULT_EMPLOYMENT_PERIOD_MONTHS),

        @NotBlank
        @Length(min = DOCTOR_COLUMN_PWZ_NUMBER_LENGTH, max = DOCTOR_COLUMN_PWZ_NUMBER_LENGTH)
        @Column(unique = true, length = DOCTOR_COLUMN_PWZ_NUMBER_LENGTH)
        var pwzNumber: String = ""
) : Employment(employee, JobPosition.DOCTOR, workTime, salary, employmentStartDate, employmentEndDate) {

}

