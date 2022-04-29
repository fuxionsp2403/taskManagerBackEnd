package com.max.taskmanagermax_api.DTO;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SignUpDTO {

    @NotBlank
    private String      nombre;
    @NotBlank
    private String      apellido;
    @NotBlank
    private String      username;
    @Email
    private String      email;
    @NotBlank
    private String      password;
    private Set<String> roles = new HashSet<>();
}
