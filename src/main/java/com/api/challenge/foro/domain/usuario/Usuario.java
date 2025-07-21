package com.api.challenge.foro.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String login;
   private String clave;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority("ROLE_USER"));
   }

   @Override
   public String getPassword() {
      return clave;
   }

   @Override
   public String getUsername() {
      return login;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true; //UserDetails.super.isAccountNonExpired();
   }

   @Override
   public boolean isAccountNonLocked() {
      return true; //UserDetails.super.isAccountNonLocked();
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true; //UserDetails.super.isCredentialsNonExpired();
   }

   @Override
   public boolean isEnabled() {
      return true; //UserDetails.super.isEnabled();
   }
}
