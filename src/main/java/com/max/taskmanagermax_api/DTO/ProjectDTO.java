package com.max.taskmanagermax_api.DTO;

import java.util.*;


import com.max.taskmanagermax_api.entity.User;
import lombok.*;

@Getter
@Setter
public class ProjectDTO {
	private int idProyecto;
    //@NotEmpty
	private String nombreProyecto;
	private Date fechaRegistro;
    //@NotEmpty
	private Date fechaFinaliza;
	private int       estado;
	private List<String> nameUser = new ArrayList<>();
    private Set<User> usuarios = new HashSet<>();
}
