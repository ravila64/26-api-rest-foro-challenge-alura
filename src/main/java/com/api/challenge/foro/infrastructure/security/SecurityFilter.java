package com.api.challenge.foro.infrastructure.security;

import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
   @Autowired
   private TokenService tokenService;
   @Autowired
   private UsuarioRepository usuarioRepository;

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      // Obtener el token del header
      var authHeader = request.getHeader("Authorization");
      System.out.println("Imprime authHeader "+authHeader);
      if (authHeader != null) {
         var token = authHeader.replace("Bearer ", "");
         var nombreUsuario = tokenService.getSubject(token); // extract username
         System.out.println("nombre usuario en security filter "+nombreUsuario);
         if (nombreUsuario != null) {
            // Token valido
            System.out.println("token valido, SecurityFilter "+token);
            var usuario = usuarioRepository.findByEmail(nombreUsuario);
            System.out.println("usuario segun token "+usuario.toString());
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                  usuario.getAuthorities()); // Forzamos un inicio de sesion
            SecurityContextHolder.getContext().setAuthentication(authentication);
         }
      }
      filterChain.doFilter(request, response);
   }
}
