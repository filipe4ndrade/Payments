package br.com.payments.models.dto;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.enitities.Client;
import br.com.payments.models.enums.ContractTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record ClientDTO(

        Long id,
        UUID UUID,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String name,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String identity,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        ContractTypeEnum contract,

        @Email(message = "Email inválido")
        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String email,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String password,

        @Valid
        AddressDTO address,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long contractNumber,

        List<Long> purchases) {

    public ClientDTO(Client client) {
        this(client.getId(), client.getUUID(), client.getName(), client.getIdentity(), client.getContract(),
                client.getEmail(), client.getPassword(), new AddressDTO(client.getAddress()),
                client.getContractNumber(), client.getPurchase().stream().map(BaseEntity::getId).toList());
    }


}
