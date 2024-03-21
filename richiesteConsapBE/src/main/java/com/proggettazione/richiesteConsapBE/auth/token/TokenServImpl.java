package com.proggettazione.richiesteConsapBE.auth.token;

import com.proggettazione.richiesteConsapBE.auth.JwtUtil;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import com.proggettazione.richiesteConsapBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class TokenServImpl implements TokenService {
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserService userService;


    @Override
    public Token addToken(Token token) {
        return tokenRepository.save(token);
    }
    /*
    public ResponseEntity<Token> addToken(@RequestBody AuthRequest authRequest) {
        Token token= new Token(authRequest.getDescrizione(), userService.findByUsername(authRequest.getUsername()));
        return ResponseEntity.ok(tokenService.addToken(token));
    }
     */
    public Token addToken2(Token token, AuthRequest authRequest) {
        Token token1= new Token(authRequest.getDescrizione(), userService.findByUsername(authRequest.getUsername()));

        return tokenRepository.save(token1);
    }








    @Override
    public void saveUserToken(UserEntity user, String accessToken) {
        var token = Token.builder()

                .user(user)
                .token(accessToken)

                .build();
        tokenRepository.save(token);
    }


}
