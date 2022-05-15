package com.max.taskmanagermax_api.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import com.max.taskmanagermax_api.entity.Comment;
import com.max.taskmanagermax_api.entity.Project;
import lombok.*;

@Getter
@Setter
public class TaskDTO {
    private long    idTarea;
    private String  nombreTarea;
    private String  contenidoTarea;
    private Date    fechaRegistro;
    private Date    fechaFinaliza;
    private int     estado;
    
//    private Set<Comment> comments = new HashSet<>();
}
