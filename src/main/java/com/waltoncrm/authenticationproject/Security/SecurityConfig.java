package com.waltoncrm.authenticationproject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
         return httpSecurity
         .csrf(AbstractHttpConfigurer::disable) //disable not for production
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                    httpForm.defaultSuccessUrl("/index");
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/req/student", "/css/**", "/js/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }
}
