package com.example.zeroTableBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/ingredients").authenticated()
                        .anyRequest().permitAll()
                );

        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/userLogin")
                        .usernameParameter("emailId")
                        .defaultSuccessUrl("/home")
                );

        return http.build();
    }
}
