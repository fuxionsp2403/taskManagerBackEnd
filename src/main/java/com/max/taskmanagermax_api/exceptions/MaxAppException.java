package com.max.taskmanagermax_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxAppException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    private HttpStatus estado;
    private String mensaje;
    
    public MaxAppException(HttpStatus estado, String mensaje, String subMensaje) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
        this.mensaje = subMensaje;
    }
}
