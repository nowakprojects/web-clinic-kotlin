package com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity

import com.github.nowakprojects.webclinicbackend.domain.abstraction.persistence.entity.DeletableEntity
import com.github.nowakprojects.webclinicbackend.domain.address.persistence.entity.Address
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotBlank
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne


const val USER_COLUMN_PESEL_LENGTH = 9

@Entity
data class User(

        @JvmField
        @NotBlank
        @Length(min = USER_COLUMN_PESEL_LENGTH, max = USER_COLUMN_PESEL_LENGTH)
        @Column(unique = true, length = USER_COLUMN_PESEL_LENGTH)
        var pesel: String = "",

        @Email
        @Column(unique = true)
        var email: String = "",

        @NotBlank
        var hashedPassword: String = "",

        @NotBlank
        var firstName: String = "",

        @NotBlank
        var lastName: String = "",

        var dateOfBirth: LocalDate? = null,

        @ManyToOne
        var address: Address? = null,

        var locked: Boolean = false
) : DeletableEntity(), UserDetails {

    fun isActive() = !locked && !deleted

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = ArrayList<GrantedAuthority>()

    override fun isEnabled(): Boolean = !locked

    override fun getUsername(): String = email

    override fun isCredentialsNonExpired(): Boolean = !locked

    override fun getPassword(): String = hashedPassword

    override fun isAccountNonExpired(): Boolean = !locked

    override fun isAccountNonLocked(): Boolean = !locked
}