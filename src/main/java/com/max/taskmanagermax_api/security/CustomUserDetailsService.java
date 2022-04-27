package com.max.taskmanagermax_api.security;

import com.max.taskmanagermax_api.entity.Role;
import com.max.taskmanagermax_api.entity.User;
import com.max.taskmanagermax_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el apodo o email : " + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRole(user.getRole()));
    }
    
    private Collection<? extends GrantedAuthority> mapRole(Set<Role> roles) {
        return roles.stream().map(role ->
                        new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
