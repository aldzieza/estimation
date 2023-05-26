package pl.olointeria.assessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                        .mvcMatchers("/").permitAll()
                        .mvcMatchers("/register", "/confirmation").permitAll()
//                .mvcMatchers("/secured").hasRole("USER")  /*  to jest moja modifikacja  */
                        .mvcMatchers("/secured").hasAnyRole("USER", "ADMIN")
                        .mvcMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().mvcMatchers(
                "/img/*.*",
                "/images/*.*",
                "static/*.*",
                "/styles/*.*",
                "/static/*.css",
                "/static/*.jpg",
                "/static/*.png",
                "/static/*.webp",
                "/static/img/*.*",
                "/static/img/*.jpg",
                "/static/img/*.png",
                "/static/img/*.webp",
                "/static/images/brand/*.webp",
                "/static/images/brand/*.*",
                "/static/images/brand/*.jpg",
                "/static/images/brand/*.png"


        );
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}