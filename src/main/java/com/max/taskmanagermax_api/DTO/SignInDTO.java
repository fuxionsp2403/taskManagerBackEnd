package com.max.taskmanagermax_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class SignInDTO {

    @NotBlank
    private String usernameOrEmail;
    @NotBlank
    private String password;


}
