package com.max.taskmanagermax_api.DTO;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public class DTOProject {
	private int idProyecto;
	private String nombreProyecto;
	private Date fechaRegistro;
	private Date fechaFinaliza;
	private int estado;
	private int idUsuario;
}
