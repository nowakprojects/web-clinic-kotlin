package com.github.nowakprojects.webclinicbackend.global.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
class JacksonConfig(private val objectMapper: ObjectMapper) {

    @Bean
    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val jsonConverter = MappingJackson2HttpMessageConverter()
        jsonConverter.objectMapper = objectMapper
        return jsonConverter
    }

}