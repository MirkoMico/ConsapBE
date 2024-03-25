package com.proggettazione.richiesteConsapBE.auth;
import com.proggettazione.richiesteConsapBE.auth.filtri.CustomAuthorizationFilter;
//import com.proggettazione.richiesteConsapBE.auth.filtri.CustomAuthenticationFilter;
import com.proggettazione.richiesteConsapBE.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    //private final LogoutHandler logoutHandler;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomAuthorizationFilter CustomAuthorizationFilter;

    @Autowired
    private UserServiceImpl     UserServiceImpl;




    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(UserServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request.requestMatchers("/auth/**", "/public/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/user/**").hasAnyAuthority("USER")
                        .requestMatchers("/adminuser/**").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        CustomAuthorizationFilter, UsernamePasswordAuthenticationFilter.class
                );
        return httpSecurity.build();

     /*   http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                      //  .requestMatchers("/registrazione/**").permitAll()
                    //    .requestMatchers(HttpMethod.POST,"/richiesta").authenticated()
                        .requestMatchers("/**").authenticated()
                    //    .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**", "/api/**").permitAll()
                   //  .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                 //       .requestMatchers(HttpMethod.POST, "/addRoleToUser").hasAuthority("ROLE_ADMIN")
                   //     .anyRequest().authenticated()


                       // .logout()
                       // .logoutUrl("/api/v1/auth/logout")
                       // .addLogoutHandler(logoutHandler)
                       // .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
             //   .addFilter(new CustomAuthenticationFilter(authenticationManager))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));*/

       // return http.build();
    }
}
