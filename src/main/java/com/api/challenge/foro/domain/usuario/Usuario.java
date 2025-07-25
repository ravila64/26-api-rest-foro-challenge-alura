package com.api.challenge.foro.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable=false)
   private String nombre;

   @Column(unique = true, nullable = false)
   private String email;

   @Column(nullable=false)
   private String clave;

   private Boolean activo;

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
      return email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }  //UserDetails.super.isAccountNonExpired()

   @Override
   public boolean isAccountNonLocked() {
      return true;
   } //UserDetails.super.isAccountNonLocked()

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   } //UserDetails.super.isCredentialsNonExpired()

   @Override
   public boolean isEnabled() {
      return true;
   } //UserDetails.super.isEnabled()
}
