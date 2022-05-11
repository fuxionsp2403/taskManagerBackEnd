package com.max.taskmanagermax_api.entity;

import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "proyectos", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombreProjecto"})})
public class Project {
    /**
     * Si vamos a poner nombres en español y que las entidades se llamen igual a los campos,
     * no pongamos nombre de columnas ya que así evitaremos la verbosidad
     */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	
	@Column(length = 50)
	private String nombreProyecto;
 
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
 
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaFinaliza;
 
	private int estado;
    
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private User userId;
	
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "usuario_proyecto", joinColumns = @JoinColumn(name = "proyecto_id", referencedColumnName = "idProyecto"),
    inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"))
	private List<User> usuarios;
 


	public Project(String nombreProyecto, Date fechaRegistro, Date fechaFinaliza, int estado) {
		this.nombreProyecto = nombreProyecto;
		this.fechaRegistro = fechaRegistro;
		this.fechaFinaliza = fechaFinaliza;
		this.estado = estado;
	}
	
	
	
	
}
