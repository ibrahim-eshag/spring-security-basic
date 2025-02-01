package com.ibrahimeshag.springsecuritybasic.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// custom authentication logic
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // here it should call UserDetailsService
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if (username.equals("Amged") && password.equals("1234")) {
            return new UsernamePasswordAuthenticationToken(
                    username, password, Arrays.asList()
            );
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
