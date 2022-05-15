package com.max.taskmanagermax_api.DTO;

import java.util.Date;
import com.max.taskmanagermax_api.entity.Task;
import lombok.*;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentDTO {
	private int idComentario;
    @NotEmpty
    @Size(min = 1, message = "el comentario debe tener al menos 1 caracter")
	private String contenido;
	private Date fechaRegistro;
//	private int idUsuario;
//	private Task tarea;
}
