package com.max.taskmanagermax_api.DTO;

import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SignUpDTO {
    
    private String      nombre;
    private String      apellido;
    private String      username;
    private String      email;
    private String      password;
    private Set<String> roles = new HashSet<>();
}
