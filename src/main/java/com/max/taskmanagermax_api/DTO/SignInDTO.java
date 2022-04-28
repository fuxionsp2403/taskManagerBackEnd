package com.max.taskmanagermax_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInDTO {
    
    private String usernameOrEmail;
    private String password;
    
    
}
