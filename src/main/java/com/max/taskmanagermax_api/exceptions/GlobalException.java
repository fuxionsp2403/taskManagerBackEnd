package com.max.taskmanagermax_api.exceptions;

import com.max.taskmanagermax_api.DTO.ErrorDetailsDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> controlResourceNotFoundException(ResourceNotFoundException e, WebRequest w) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MaxAppException.class)
    public ResponseEntity<ErrorDetailsDTO> controlMaxAppException(MaxAppException e, WebRequest w) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), e.getMensaje(), w.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDTO> controlGlobalHandlerException(Exception e, WebRequest w) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                    HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error)
                            .getField();
                    String message = error.getDefaultMessage();
                    
                    errors.put(fieldName, message);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
}
