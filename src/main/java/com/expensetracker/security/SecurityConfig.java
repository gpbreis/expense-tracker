package com.expensetracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
                    try {
                        auth
                                .requestMatchers("/login", "/register", "/register/save")
                                .permitAll()
                                .requestMatchers("/persons", "/persons/create", "/persons/{personId}/edit", "/persons/search")
                                .hasAnyAuthority("ADMIN", "USER")
                                .and()
                                .formLogin(form -> form
                                        .loginPage("/login")
                                        .defaultSuccessUrl("/persons")
                                        .loginProcessingUrl("/login")
                                        .failureUrl("/login?error=true")
                                        .permitAll())
                                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                );
        return http.build();
    }

    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
