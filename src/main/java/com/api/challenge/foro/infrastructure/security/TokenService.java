package com.api.challenge.foro.infrastructure.security;

import com.api.challenge.foro.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {
   @Value("${api.security.token.secret}")
   private String secret;  // properties

   public String generarToken(Usuario usuario) {
      try {
         var algoritmo = Algorithm.HMAC256(secret);
         return JWT.create()
               .withIssuer("API Voll.med")
               .withSubject(usuario.getEmail())
               .withExpiresAt(fechaExpiracion())
               .sign(algoritmo);
      } catch (JWTCreationException exception) {
         throw new RuntimeException("error al generar el token JWT", exception);
      }
   }

//    example:expira 3 horas despues desde que se reciba el token
   private Instant fechaExpiracion() {
      return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-05:00"));  // utc:-05:00 colombia, bog, lima, quito
   }

   public String getSubject(String tokenJWT) {
      if (tokenJWT == null) {
         throw new ValidationException("El token es nulo.");
      }
      try {
         var algoritmo = Algorithm.HMAC256(secret);
         return JWT.require(algoritmo)
               .withIssuer("API Voll.med")
               .build()
               .verify(tokenJWT)
               .getSubject();
      } catch (JWTVerificationException exception) {
         throw new RuntimeException("Token JWT invalido o expirado !!! "+exception.getMessage());
      }
   }
}
