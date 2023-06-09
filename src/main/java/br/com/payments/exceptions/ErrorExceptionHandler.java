package br.com.payments.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> error400a(IllegalArgumentException ex){
        String errorMessage = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Stream<DataValidationExceptionDto> handlerErrorBadRequest(MethodArgumentNotValidException ex){
        List<FieldError> listErrors = ex.getFieldErrors();
        return listErrors.stream().map((errors) -> new DataValidationExceptionDto(errors.getField(), errors.getDefaultMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Stream<DataValidationExceptionDto> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = "Campo já cadastrados";
        List<DataValidationExceptionDto> errorDtoList = new ArrayList<>();
        errorDtoList.add(new DataValidationExceptionDto("Email, Identity ou Contract", errorMessage));
        return errorDtoList.stream();
    }

}
