package com.max.taskmanagermax_api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserManager implements UserDetails {
    
    private String                                 nombre;
    private String                                 apellido;
    private String                                 username;
    private String                                 email;
    private String                                 password;
    private int                                    estado;
    private Collection<? extends GrantedAuthority> authorities;
    
    
    public UserManager(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    public static UserManager build(User usuario) {
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name())).collect(Collectors.toList());
        return new UserManager(usuario.getNombre(), usuario.getApellido(), usuario.getUsername(),
                usuario.getEmail(), usuario.getPassword(), usuario.getEstado(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
