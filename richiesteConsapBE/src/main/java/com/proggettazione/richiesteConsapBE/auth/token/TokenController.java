package com.proggettazione.richiesteConsapBE.auth.token;

import com.proggettazione.richiesteConsapBE.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {
    @Autowired
    private final TokenService tokenService;

    @Autowired
    private AuthService authService;


    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Token> addToken(@RequestBody AuthRequest authRequest) {
        Token token= new Token(authRequest.getDescrizione(), userService.findByUsername(authRequest.getUsername()));
        return ResponseEntity.ok(tokenService.addToken(token));
    }


    @PostMapping("/signup")
    public ResponseEntity<AuthRequest> signUp(@RequestBody AuthRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/log")
    public ResponseEntity<AuthRequest>login(@RequestBody AuthRequest resp){
        System.out.println("ciao"+resp);
        return ResponseEntity.ok(authService.login(resp));

    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthRequest> refreshToken(@RequestBody AuthRequest refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }







}
