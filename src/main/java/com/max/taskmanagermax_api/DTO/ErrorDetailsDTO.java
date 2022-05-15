package com.max.taskmanagermax_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetailsDTO {
    
    private Date   tiempo;
    private String mensaje;
    private String detalles;
}
