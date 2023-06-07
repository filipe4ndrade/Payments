package br.com.payments.models.dto;

import br.com.payments.models.enitities.Address;
import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String street,


        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String number,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String city,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String state,

        String complement) {

    public AddressDTO(Address address) {
        this(address.getStreet(), address.getNumber(), address.getCity(),address.getState(), address.getComplement());
    }
}
