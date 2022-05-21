package com.max.taskmanagermax_api.DTO;

import java.util.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.max.taskmanagermax_api.entity.Task;
import com.max.taskmanagermax_api.entity.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProjectDTO {
    
    private int    idProyecto;
    @NotEmpty
    @Size (min = 2, max = 50, message = "El nombre del proyecto debe tener al menos dos caracteres y máximo 50")
    private String nombreProyecto;
    private Date   fechaRegistro;
    
    private Date fechaFinaliza;
    private int  estado;
    
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private List<String> nameUser;
    private Set<User>    usuarios;
    
    private Set<Task> tasks;
}
