package com.proggettazione.richiesteConsapBE.auth;


import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class JwtUtil {

    /*    private static final int expireHourToken = 24;
        private static final int expireHourRefreshToken = 72;

        private static final String SECRET = "FBA898697394CDBC534E7ED86A97AA59F627FE6B309E0A21EEC6C9B130E0369C";


        public  String createAccessToken(String username) {
            try {
                JWTClaimsSet claims = new JWTClaimsSet.Builder()
                        .subject(username)
                        //.issuer(issuer)
                      //  .claim("roles", roles)
                        .expirationTime(Date.from(Instant.now().plusSeconds(expireHourToken * 3600)))
                        .issueTime(new Date())
                        .build();

                Payload payload = new Payload(claims.toJSONObject());

                JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256),
                        payload);

                jwsObject.sign(new MACSigner(SECRET));
                return jwsObject.serialize();
            }
            catch (JOSEException e) {
                throw new RuntimeException("Error to create JWT", e);
            }
        }

        public  String createRefreshToken(String userName) {
            //like createAccessToken method, but without issuer, roles...
            try {
                JWTClaimsSet claims = new JWTClaimsSet.Builder()
                        .subject(userName)
                        .expirationTime(Date.from(Instant.now().plusSeconds(expireHourToken * 3600)))
                        .build();

                Payload payload = new Payload(claims.toJSONObject());

                JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256),
                        payload);

                jwsObject.sign(new MACSigner(SECRET));
                return jwsObject.serialize();
            }
            catch (JOSEException e) {
                throw new RuntimeException("Errore durante la creazione del JWT", e);
            }


        }

        public static UsernamePasswordAuthenticationToken parseToken(String token) throws JOSEException, ParseException,
                BadJOSEException {

            byte[] secretKey = SECRET.getBytes();
            SignedJWT signedJWT = SignedJWT.parse(token);
            signedJWT.verify(new MACVerifier(secretKey));
            ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();

            JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(JWSAlgorithm.HS256,
                    new ImmutableSecret<>(secretKey));
            jwtProcessor.setJWSKeySelector(keySelector);
            jwtProcessor.process(signedJWT, null);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
            String username = claims.getSubject();
            var roles = (List<String>) claims.getClaim("roles");
            var authorities = roles == null ? null : roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(authorities, username, null);
        }*/


    private SecretKey Key;
    private  static  final long EXPIRATION_TIME = 86400000; //24hours or 86400000 milisecs
    public JwtUtil(){
        String secreteString = "843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3";
        byte[] keyBytes = Base64.getDecoder().decode(secreteString.getBytes(StandardCharsets.UTF_8));
        this.Key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }
    public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(Key).build().parseSignedClaims(token).getPayload());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }





    }


