package br.com.payments.controllers;

import br.com.payments.models.dto.TransactionDTO;
import br.com.payments.services.PurchaseService;
import br.com.payments.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionPurchase {

    private final TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTORequest,
                                                               UriComponentsBuilder uriComponentsBuilder){
        TransactionDTO transactionDTOResponse = transactionService.createTransaction(transactionDTORequest);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(transactionDTOResponse.id()).toUri();
        return ResponseEntity.created(uri).body(transactionDTOResponse);
    }
}
