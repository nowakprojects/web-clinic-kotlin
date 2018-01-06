package com.github.nowakprojects.webclinicbackend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebClinicBackendApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebClinicBackendApplication::class.java, *args)
}
