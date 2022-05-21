package com.max.taskmanagermax_api.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tareas")
public class Task {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idTarea;
    
    @Column (length = 50)
    private String nombreTarea;
    
    @Column (length = 150)
    private String contenidoTarea;
    
    @Temporal (TemporalType.TIMESTAMP)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fechaRegistro;
    
    @Temporal (TemporalType.DATE)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaFinaliza;
    
    private int estado;
    
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "idProyecto", nullable = false)
    private Project proyecto;
    
    @OneToMany (mappedBy = "tarea", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Comment> comments = new HashSet<>();
    
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name = "usuario_tarea", joinColumns = @JoinColumn (name = "tarea_id", referencedColumnName = "idTarea"),
            inverseJoinColumns = @JoinColumn (name = "usuario_id", referencedColumnName = "id"))
    private Set<User> usuarios = new HashSet<>();
    
    public Task(String nombreTarea, String contenidoTarea, Date fechaRegistro, Date fechaFinaliza, int estado) {
        this.nombreTarea = nombreTarea;
        this.contenidoTarea = contenidoTarea;
        this.fechaRegistro = fechaRegistro;
        this.fechaFinaliza = fechaFinaliza;
        this.estado = estado;
    }
    
}
