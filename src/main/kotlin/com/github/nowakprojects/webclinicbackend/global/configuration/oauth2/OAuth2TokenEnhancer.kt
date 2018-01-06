package com.github.nowakprojects.webclinicbackend.global.configuration.oauth2

import com.github.nowakprojects.webclinicbackend.domain.authentication.mapper.UserMapper
import com.github.nowakprojects.webclinicbackend.domain.authentication.persistence.entity.User
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import org.springframework.stereotype.Component
import java.util.*

@Component
class OAuth2TokenEnhancer(
        private val userMapper: UserMapper
) : TokenEnhancer {

    override fun enhance(accessToken: OAuth2AccessToken, authentication: OAuth2Authentication): OAuth2AccessToken {
        addLoggedUserInfoToToken(accessToken as DefaultOAuth2AccessToken, authentication)
        return accessToken
    }

    private fun addLoggedUserInfoToToken(accessToken: DefaultOAuth2AccessToken, authentication: OAuth2Authentication) {
        val loggedUser = authentication.principal as User
        val additionalInfo = HashMap<String, Any>()
        additionalInfo.put(ATTR_LOGGED_USER, userMapper.toUserInfoDto(loggedUser))
        accessToken.additionalInformation = additionalInfo
    }

    companion object {

        private val ATTR_LOGGED_USER = "logged_user"
    }
}
