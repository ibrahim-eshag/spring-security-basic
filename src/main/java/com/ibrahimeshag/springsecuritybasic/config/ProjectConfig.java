package com.ibrahimeshag.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        // overriding the default user details requires
        // 1- a user with password and authority (any name for now).
        //2- a password encoder.

        var user = User
                .withUsername("Amged")
                .password("1234")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return   NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(c -> c
                .requestMatchers("/world").authenticated()
                .anyRequest().permitAll()
        );
        return http.build();
    }

}
