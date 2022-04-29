package com.max.taskmanagermax_api.entity;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tareas")
public class Task {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idTarea")
	private int idTarea;
	
	@Column(name = "nombreTarea", length = 50)
	private String nombreTarea;
	
	@Column(name = "contenidoTarea", length = 150)
	private String contenidoTarea;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private User usuario;
	
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
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProyecto")
	private Project proyecto;

	public Task(String nombreTarea, String contenidoTarea, Date fechaRegistro, Date fechaFinaliza, int estado) {
		this.nombreTarea = nombreTarea;
		this.contenidoTarea = contenidoTarea;
		this.fechaRegistro = fechaRegistro;
		this.fechaFinaliza = fechaFinaliza;
		this.estado = estado;
	}
	
}
