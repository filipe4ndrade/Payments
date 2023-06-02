package br.com.payments.models.dto;

import br.com.payments.models.client.Client;
import br.com.payments.models.enums.ContractTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record ClientDTO(

        Long id,
        UUID UUID,

        @NotBlank(message = "O campo não pode estar vazio")
        String name,

        @NotBlank(message = "O campo não pode estar vazio")
        String identity,

        ContractTypeEnum contract,

        @Email(message = "Email inválido")
        @NotBlank(message = "O campo não pode estar vazio")
        String email,

        @NotBlank(message = "O campo não pode estar vazio")
        String password,

        @NotBlank(message = "O campo não pode estar vazio")
        @Valid
        AddressDTO address,

        Long contractNumber,

        List<Long> purchases) {

    public ClientDTO(Client client) {
        this(client.getId(), client.getUUID(), client.getName(), client.getIdentity(), client.getContract(),
                client.getEmail(), client.getPassword(), new AddressDTO(client.getAddress()),
                client.getContractNumber(), client.getPurchase().stream().map((purchase)-> purchase.getId()).toList());
    }


}
