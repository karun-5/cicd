/*
package com.example.springsec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/reports/export")
                        .hasAuthority("REPORT_EXPORT")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(logout->logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    UserDetailsService users(){
        UserDetails user= User.withUsername("user")
                .password(encoder().encode("user123"))
                .roles("USER")
                .build();

        UserDetails admin= User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .authorities("REPORT_EXPORT")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
*/