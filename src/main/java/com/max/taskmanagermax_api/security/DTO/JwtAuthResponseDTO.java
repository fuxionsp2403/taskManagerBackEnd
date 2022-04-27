package com.max.taskmanagermax_api.security.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtAuthResponseDTO {
    
    private String accessToken;
    private String tokenType = "Bearer";
    
    public JwtAuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
