package com.max.taskmanagermax_api.security.DTO;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;

@Getter
@Setter
public class JwtAuthResponseDTO {
    
    private String accessToken;
    @NonNull
    private String tokenType = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    
    public JwtAuthResponseDTO(String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.username = username;
        this.authorities = authorities;
    }
}
