/*package com.proggettazione.richiesteConsapBE.auth.filtri;
import com.proggettazione.richiesteConsapBE.auth.JwtUtil;
import com.proggettazione.richiesteConsapBE.auth.token.AuthRequest;
import com.proggettazione.richiesteConsapBE.auth.token.Token;
import com.proggettazione.richiesteConsapBE.auth.token.TokenRepository;
import com.proggettazione.richiesteConsapBE.auth.token.TokenServImpl;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String ERRORE_MESSAGGIO_CREDENZIALI = "Autenticazione non riuscita per username utente: %s e password: %s";

    private final AuthenticationManager AUTHENTICATION_MANAGER;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    private TokenServImpl tokenServ;

    @Autowired
    AuthRequest authRequest;




    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = null;
        String password = null;
       // setFilterProcessesUrl( "/log");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> map = objectMapper.readValue(request.getInputStream(), Map.class);
            username = map.get("username");
            password = map.get("password");
            log.debug("Accesso con e-mail: {}", username);
            return AUTHENTICATION_MANAGER.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (AuthenticationException e) {
            log.error(String.format(ERRORE_MESSAGGIO_CREDENZIALI, username, password), e);
            throw e;
        }
        catch (Exception e) {
            response.setStatus(INTERNAL_SERVER_ERROR.value());
            Map<String, String> error = new HashMap<>();
            error.put("errorMessage", e.getMessage());
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), error);
            throw new RuntimeException(String.format("Errore in attemptAuthentication con username %s e password %s", username, password), e);
        }
    }

    //crea l'access token e il refresh token e li aggiunge all'header di risposta della chiamata /login.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        String accessToken = JwtUtil.createAccessToken(user.getUsername(), request.getRequestURL().toString(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        System.out.println("USER IS: "+ user + "token: " +accessToken );

       // AuthRequest authRequest = new AuthRequest(); // crea un'istanza di AuthRequest con i dati necessari
       // authRequest.setUsername(user.getUsername());
       // authRequest.setDescrizione("descrizione del token");

        //Token newToken = tokenServ.addToken2(new Token(), authRequest);

        //tokenServ.addToken2( new Token(),  authRequest(user.getUsername()));

        String refreshToken = JwtUtil.createRefreshToken(user.getUsername());

        response.addHeader("access_token", accessToken);
        response.addHeader("refresh_token", refreshToken);
        response.addHeader("user", user.getUsername());




    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> error = new HashMap<>();
        error.put("errorMessage", "Bad credentials");
        response.setContentType(APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), error);
    }



}*/
