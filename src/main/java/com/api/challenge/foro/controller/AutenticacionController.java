package com.api.challenge.foro.controller;

import com.api.challenge.foro.domain.usuario.DatosAutenticaUsuario;
import com.api.challenge.foro.domain.usuario.Usuario;
import com.api.challenge.foro.infrastructure.security.DatosJWTToken;
import com.api.challenge.foro.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticaUsuario datosAutenticaUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticaUsuario.email(),
                datosAutenticaUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}

