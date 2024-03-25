package com.proggettazione.richiesteConsapBE.auth.token;

import com.proggettazione.richiesteConsapBE.auth.JwtUtil;
import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import com.proggettazione.richiesteConsapBE.repository.RoleRepository;
import com.proggettazione.richiesteConsapBE.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private JwtUtil jwtUtils;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TokenRepository tokenRepository;
    /*
    public ReqRes signIn(ReqRes signinRequest){
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
            var user = ourUserRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);




            // Salvare il token e l'ID utente nella tabella "token"
            Token token = new Token();
            token.setOurUsers(user);
            token.setToken(jwt);

            tokenRepository.save(token);
            System.out.println(ourUserRepo+" ciao");


            response.setStatusCode(200);
            response.setToken(jwt);


            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
     */


    public AuthRequest signUp(AuthRequest registrationRequest){
        AuthRequest resp = new AuthRequest();
        try {
            UserEntity users = new UserEntity();
            users.setUsername(registrationRequest.getUsername());
            users.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
           // RoleEntity role = roleRepository.findById(registrationRequest.getRoleName());
           // Users.setRoles(role);
            UserEntity  userResult = userRepository.save(users);
            if (userResult != null && userResult.getUserId()>0) {
                resp.setUsername(userResult.getUsername());
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }



    public AuthRequest login(AuthRequest authRequest) {
        AuthRequest response = new AuthRequest();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                    authRequest.getPassword()));
            System.out.println("CIAO" + authRequest.getUsername());
            var user= userRepository.findByUsername(authRequest.getUsername());
            System.out.println("USER" + user);
            var jwt = jwtUtils.generateToken(user);
           var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            System.out.println("token: "+jwt  + "user: "+user);



            Token token = new Token();
            token.setUser(user);
            token.setToken(jwt);
            tokenRepository.save(token);

            response.setToken(jwt);
            response.setStatusCode(200);
            response.setExpirationTime("24Hr");
           response.setUsername(authRequest.getUsername());

        } catch (Exception e){
        response.setStatusCode(500);
        response.setError(e.getMessage());
    }
        return response;


    }
    public AuthRequest refreshToken(AuthRequest refreshTokenReqiest){
        AuthRequest response = new AuthRequest();
      //  String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
        String ourUsrerName = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
        UserEntity users = userRepository.findByUsername(ourUsrerName);
        if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenReqiest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }


}
