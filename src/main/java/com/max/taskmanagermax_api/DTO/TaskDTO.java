package com.max.taskmanagermax_api.DTO;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public class TaskDTO {
    
    private long   idTarea;
    private String nombreTarea;
    private String contenidoTarea;
    private Date   fechaRegistro;
    private Date   fechaFinaliza;
    private int    estado;
}