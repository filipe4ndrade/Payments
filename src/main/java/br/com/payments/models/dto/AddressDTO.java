package br.com.payments.models.dto;

import br.com.payments.models.address.Address;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AddressDTO(
        @NotBlank
        String street,


        @NotBlank
        String number,

        @NotBlank
        String city,

        @NotBlank
        String state,

        String complement) {

    public AddressDTO(Address address) {
        this(address.getStreet(), address.getNumber(), address.getCity(),address.getState(), address.getComplement());
    }
}
