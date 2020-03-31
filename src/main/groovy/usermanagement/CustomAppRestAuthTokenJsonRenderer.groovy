package usermanagement

import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.rendering.AccessTokenJsonRenderer
import groovy.json.JsonBuilder
import org.springframework.security.core.GrantedAuthority

class CustomAppRestAuthTokenJsonRenderer implements AccessTokenJsonRenderer   {
    @Override
    String generateJson(AccessToken accessToken) {
        Map response = [
                id           : accessToken.principal.id,
                username     : accessToken.principal.username,
                access_token : accessToken.accessToken,
                token_type   : "Bearer",
                refresh_token: accessToken.refreshToken,
                roles        : accessToken.authorities.collect { GrantedAuthority role -> role.authority }
        ]

        return new JsonBuilder( response ).toPrettyString()
    }
}
