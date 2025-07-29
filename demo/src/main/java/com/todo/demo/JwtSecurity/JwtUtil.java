package com.todo.demo.JwtSecurity;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {


    @Value("${jwt.secret}")
    private String secretKey;
    private static long EXPIRATION_TIME = 1000*60 *60; // 1 hora

    public JwtUtil(){

    }

    public String generateTocken(String email){
        return JWT.create()
        .withSubject(email)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
        .sign(Algorithm.HMAC256(secretKey));
    }

    public String extractEmail(String token){
        return JWT.require(Algorithm.HMAC256(secretKey))
            .build()
            .verify(token)
            .getSubject();
    }


    public boolean isTokenValid(String token, String email){
        try{
            String tokenEmail = extractEmail(token);
            return tokenEmail.equals(email) && !isTokenExpired(token);
        }catch(JWTVerificationException e){
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = JWT.require(Algorithm.HMAC256(secretKey))
            .build()
            .verify(token)
            .getExpiresAt();
        return expiration.before(new Date());
    }
}
