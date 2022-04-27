package com.max.taskmanagermax_api.entity;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "proyectos")
public class Project {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idProyecto")
	private int idProyecto;
	
	@Column(name = "nombreProyecto", length = 50)
	private String nombreProyecto;
	
	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	@Column(name = "fechaFinaliza")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaFinaliza;
	
	@Column(name = "estado")
	private int estado;
	
	// falta notaciones para relacionar con la tabla de usario (gonzalo)
	@Column(name = "idUsuario")
	private int idUsuario;
}
