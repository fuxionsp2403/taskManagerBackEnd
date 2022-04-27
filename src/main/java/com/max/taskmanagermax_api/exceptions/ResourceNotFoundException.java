package com.max.taskmanagermax_api.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private String recurso;
    private String columna;
    private long valorColumna;
    
    public ResourceNotFoundException(String recurso, String columna, long valorColumna) {
        super(String.format("%s No encontrado con %s :  '%s'", recurso, columna, valorColumna));
        this.recurso = recurso;
        this.columna = columna;
        this.valorColumna = valorColumna;
    }
}
