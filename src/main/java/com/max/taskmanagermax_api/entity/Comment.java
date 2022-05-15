package com.max.taskmanagermax_api.entity;

import java.util.Date;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "comentarios")
public class Comment {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idComentario;
    
    @Column (length = 350)
    private String contenidoComentario;
    
    @Temporal (TemporalType.TIMESTAMP)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fechaRegistro;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "idTarea", nullable = false)
    private Task tarea;
    
}
