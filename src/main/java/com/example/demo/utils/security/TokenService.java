package com.example.demo.utils.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){

        System.out.println(secret);

        try{
            return JWT.create()
                    .withIssuer("DEMO")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtv = JWT.require(algorithm)
                    .withIssuer("DEMO")
                    .build();
            return jwtv.verify(token).getSubject();
        }catch(JWTVerificationException e){
            throw new RuntimeException("Token JWT inválido");
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    }

}
