package br.com.payments.controllers;

import br.com.payments.models.dto.ClientDTO;
import br.com.payments.services.ClientService;
import br.com.payments.services.InvoiceService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/cadastro")
    public ResponseEntity<ClientDTO> cadastrarClient(@RequestBody ClientDTO clientDTORequest,
                                                     UriComponentsBuilder uriComponentsBuilder) {
        ClientDTO clientDTOResponse = clientService.cadastrarClient(clientDTORequest);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(clientDTOResponse.id()).toUri();
        return ResponseEntity.created(uri).body(clientDTOResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deletarClient(id);
        return ResponseEntity.noContent().build();
    }
}
