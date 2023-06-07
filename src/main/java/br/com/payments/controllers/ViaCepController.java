package br.com.payments.controllers;

import br.com.payments.models.dto.AddressDTO;
import br.com.payments.services.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("via-cep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<AddressDTO> getCep(@PathVariable String cep) {
        AddressDTO addressDTO = viaCepService.getCep(cep);
        return ResponseEntity.ok(addressDTO);
    }
}
