package com.max.taskmanagermax_api.DTO;

import java.util.Date;
import java.util.List;


import com.max.taskmanagermax_api.entity.User;
import lombok.*;

@Data
public class ProjectDTO {
	private int idProyecto;
    //@NotEmpty
	private String nombreProyecto;
	private Date fechaRegistro;
    //@NotEmpty
	private Date fechaFinaliza;
	private int       estado;
	private List<User> usuarios;
}
