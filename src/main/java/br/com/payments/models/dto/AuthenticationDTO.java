package br.com.payments.models.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String login,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String senha
)  {
}
