package com.max.taskmanagermax_api.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
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
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_proyecto", joinColumns = @JoinColumn(name = "proyecto_id", referencedColumnName = "idProyecto"),
    inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"))
	private Set<User> usuarios=new HashSet<>();

	public Project(String nombreProyecto, Date fechaRegistro, Date fechaFinaliza, int estado) {
		this.nombreProyecto = nombreProyecto;
		this.fechaRegistro = fechaRegistro;
		this.fechaFinaliza = fechaFinaliza;
		this.estado = estado;
	}
	
	
	
	
}
