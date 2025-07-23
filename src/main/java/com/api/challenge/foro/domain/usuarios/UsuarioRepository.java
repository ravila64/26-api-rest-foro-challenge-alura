package com.api.challenge.foro.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Autor, Long> {
    UserDetails findByLogin(String username);
}