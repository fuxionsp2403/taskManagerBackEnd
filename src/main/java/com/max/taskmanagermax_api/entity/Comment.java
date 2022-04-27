package com.max.taskmanagermax_api.entity;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "comentarios")
public class Comment {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idComentario")
	private int idComentario;
	
	@Column(name = "contenidoComentario", length = 350)
	private String contenidoComentario;
	
	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	private int idUsuario;
}
