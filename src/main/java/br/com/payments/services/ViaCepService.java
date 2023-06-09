package br.com.payments.services;

import br.com.payments.models.dto.AddressDTO;
import br.com.payments.models.viacep.ViaCepDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    public AddressDTO getCep(String cep) {
        if (!isValidCep(cep)) {
            throw new IllegalArgumentException("CEP inválido!");
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ViaCepDTO> response = restTemplate.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json", cep), ViaCepDTO.class);

        ViaCepDTO viacepResponse = response.getBody();
        return new AddressDTO(viacepResponse.logradouro(),null,viacepResponse.localidade(),viacepResponse.uf()
                , viacepResponse.complemento());
    }

    private boolean isValidCep(String cep) {
        return cep.matches("\\d{8}");
    }
}
