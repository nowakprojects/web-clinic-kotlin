package com.github.nowakprojects.webclinicbackend.domain.employee.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.JobPosition
import com.github.nowakprojects.webclinicbackend.domain.employee.model.enumeration.WorkTime
import java.time.LocalDate
import javax.persistence.Entity

@Entity
class Manager(
        employee: User = User(),
        workTime: WorkTime = WorkTime.FULL_TIME,
        salary: Long = DEFAULT_EMPLOYMENT_SALARY,
        employmentStartDate: LocalDate = LocalDate.now(),
        employmentEndDate: LocalDate = LocalDate.now().plusMonths(DEFAULT_EMPLOYMENT_PERIOD_MONTHS),
        var additionalSalary: Long? = null
) : Employment(employee, JobPosition.MANAGER, workTime, salary, employmentStartDate, employmentEndDate) {

}

