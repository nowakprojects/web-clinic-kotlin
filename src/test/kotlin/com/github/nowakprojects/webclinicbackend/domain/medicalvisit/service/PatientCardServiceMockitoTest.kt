package com.github.nowakprojects.webclinicbackend.domain.medicalvisit.service

import com.github.nowakprojects.webclinicbackend.domain.errorhandling.model.exception.DomainException
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.entity.PatientCard
import com.github.nowakprojects.webclinicbackend.domain.patientcard.persistence.repository.PatientCardRepository
import com.github.nowakprojects.webclinicbackend.domain.patientcard.service.PatientCardService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PatientCardServiceMockitoTest {

    val patientCardRepository: PatientCardRepository = Mockito.mock(PatientCardRepository::class.java)

    val patientCardService: PatientCardService = PatientCardService(patientCardRepository)

    var samplePatientCardList: List<PatientCard> = emptyList()

    @Before
    fun setUp() {
        samplePatientCardList = listOf(
                PatientCard().apply { this.id = 1; this.deleted = true },
                PatientCard().apply { this.id = 2 },
                PatientCard().apply { this.id = 3 },
                PatientCard().apply { this.id = 4 },
                PatientCard().apply { this.id = 5; this.deleted = true }
        )
    }

    @Test
    fun `Mockito should initialized mocks`() {
        assertThat(patientCardRepository).isNotNull()
    }

    @Test
    fun `Method findAllPatientCard should return empty list if no patient cards exist`() {
        Mockito.`when`(patientCardRepository.findAllByDeletedIsFalse())
                .thenReturn(emptyList())

        assertThat(patientCardService.findAllPatientCard()).isEmpty()
    }

    @Test
    fun `Method findAllPatientCard should return all not deleted patient cards`() {
        Mockito.`when`(patientCardRepository.findAllByDeletedIsFalse())
                .thenReturn(samplePatientCardList.filter { !it.deleted })


        assertThat(patientCardService.findAllPatientCard()).allMatch { !it.deleted }
        assertThat(patientCardService.findAllPatientCard()).hasSize(3)
    }

    @Test
    fun `Method tryToFindPatientCardByPatientId should return PatientCard with given id`() {
        val patientCardId = 2L
        Mockito.`when`(patientCardRepository.findOneByIdAndDeletedIsFalse(patientCardId))
                .thenReturn(samplePatientCardList.first { it.id == patientCardId })


        assertThat(patientCardService.tryToFindPatientCardByPatientId(patientCardId)).isNotNull()
    }

    @Test(expected = DomainException::class)
    fun `Method tryToFindPatientCardByPatientId should throw exception if PatientCard not persisted`() {
        val patientCardId = 99L
        Mockito.`when`(patientCardRepository.findOneByIdAndDeletedIsFalse(patientCardId))
                .thenReturn(null)


        patientCardService.tryToFindPatientCardByPatientId(patientCardId)
    }
}