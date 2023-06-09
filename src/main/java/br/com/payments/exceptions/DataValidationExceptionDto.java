package br.com.payments.exceptions;

import org.springframework.validation.FieldError;

public record DataValidationExceptionDto(String campo, String mensagem) {

    public DataValidationExceptionDto(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }

}
