package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.entity.MedicalVisit
import com.github.nowakprojects.webclinicbackend.domain.medicalvisit.persistence.repository.MedicalVisitRepository
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import com.github.nowakprojects.webclinicbackend.testsample.DoctorSampleFactory.Companion.createSampleDoctor
import com.github.nowakprojects.webclinicbackend.testsample.MedicalVisitSampleFactory.Companion.createSampleTodayMedicalVisit
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.time.LocalDate

class MedicalVisitServiceMockitoTest {

    val medicalVisitRepository: MedicalVisitRepository = Mockito.mock(MedicalVisitRepository::class.java)
    val medicalVisitService: MedicalVisitService = MedicalVisitService(medicalVisitRepository)


    var sampleMedicalVisitsList: List<MedicalVisit> = emptyList()

    @Before
    fun setUp() {
        sampleMedicalVisitsList = listOf(
                createSampleTodayMedicalVisit(91, PatientCard(), createSampleDoctor(81)),
                createSampleTodayMedicalVisit(92, PatientCard(), createSampleDoctor(81)),
                createSampleTodayMedicalVisit(93, PatientCard(), createSampleDoctor(81)),
                createSampleTodayMedicalVisit(94, PatientCard(), createSampleDoctor(82))
        )
    }

    @Test
    fun `Mockito should initalized mocks`() {
        assertThat(medicalVisitRepository).isNotNull()
    }

    @Test
    fun `Method findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate should return list of one list if there is only one today visit for doctor`() {
        val loggedDoctorId = 82L;
        val localDateNow = LocalDate.now();
        `when`(medicalVisitRepository.findAllByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, LocalDate.now()))
                .thenReturn(findSampleMedicalVisitByDoctorId(loggedDoctorId))

        val foundMedicalVisits = medicalVisitService.findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, localDateNow)

        assertThat(foundMedicalVisits).hasSize(1)
    }

    @Test
    fun `Method findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate should return list of doctor visits for today`() {
        val loggedDoctorId = 81L;
        val localDateNow = LocalDate.now();
        `when`(medicalVisitRepository.findAllByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, LocalDate.now()))
                .thenReturn(findSampleMedicalVisitByDoctorId(loggedDoctorId))

        val foundMedicalVisits = medicalVisitService.findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, localDateNow)

        assertThat(foundMedicalVisits).hasSize(3)
    }

    @Test
    fun `Method findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate should return empty list if doctor haven't visits today`() {
        val loggedDoctorId = 83L;
        val localDateNow = LocalDate.now();
        `when`(medicalVisitRepository.findAllByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, LocalDate.now()))
                .thenReturn(findSampleMedicalVisitByDoctorId(loggedDoctorId))

        val foundMedicalVisits = medicalVisitService.findAllMedicalVisitByDoctorEmployeeIdAndPlannedDate(loggedDoctorId, localDateNow)

        assertThat(foundMedicalVisits).isEmpty()
    }

    @Test
    fun `Method findMedicalVisitById should set cancel on true`() {
        val medicalVisitId = 1L
        val sampleMedicalVisit = createSampleTodayMedicalVisit(medicalVisitId);
        `when`(medicalVisitRepository.findOneByIdAndDeletedIsFalse(medicalVisitId))
                .thenReturn(sampleMedicalVisit)

        `when`(medicalVisitRepository.save(any(MedicalVisit::class.java)))
                .thenReturn(sampleMedicalVisit)

        medicalVisitService.cancelMedicalVisitById(medicalVisitId)

        assertThat(sampleMedicalVisit.cancelled).isTrue()
    }

    @Test(expected = DomainException::class)
    fun `Method cancelMedicalVisitById should throw exception if MedicalVisit not persisted`() {
        val medicalVisitId = 1L
        `when`(medicalVisitRepository.findOneByIdAndDeletedIsFalse(medicalVisitId))
                .thenReturn(null)

        medicalVisitService.cancelMedicalVisitById(medicalVisitId)
    }

    @Test(expected = DomainException::class)
    fun `Method startMedicalVisitById should throw exception if MedicalVisit not persisted`() {
        val medicalVisitId = 1L
        `when`(medicalVisitRepository.findOneByIdAndDeletedIsFalse(medicalVisitId))
                .thenReturn(null)

        medicalVisitService.startMedicalVisitById(medicalVisitId)
    }

    @Test(expected = DomainException::class)
    fun `Method finishMedicalVisitById should throw exception if MedicalVisit not persisted`() {
        val medicalVisitId = 1L
        `when`(medicalVisitRepository.findOneByIdAndDeletedIsFalse(medicalVisitId))
                .thenReturn(null)

        medicalVisitService.finishMedicalVisitById(medicalVisitId)
    }


    fun findSampleMedicalVisitByDoctorId(doctorId: Long)
            = sampleMedicalVisitsList.filter { it -> it.doctor.id == doctorId }


}