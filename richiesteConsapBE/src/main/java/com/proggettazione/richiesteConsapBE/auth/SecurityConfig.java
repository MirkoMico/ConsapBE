package com.proggettazione.richiesteConsapBE.auth;
import com.proggettazione.richiesteConsapBE.auth.filtri.CustomAuthorizationFilter;
import com.proggettazione.richiesteConsapBE.auth.filtri.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers("/registrazione/**").permitAll()
                        .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilter(new CustomAuthenticationFilter(authenticationManager))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));

        return http.build();
    }
}
