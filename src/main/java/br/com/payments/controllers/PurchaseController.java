package br.com.payments.controllers;

import br.com.payments.models.dto.PurchaseDTO;
import br.com.payments.services.InvoiceService;
import br.com.payments.services.PurchaseService;
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
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/cadastro")
    public ResponseEntity<PurchaseDTO> cadastrarPurchase(@RequestBody PurchaseDTO purchaseDTORequest,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        PurchaseDTO purchaseDTOResponse = purchaseService.cadastrarPurchase(purchaseDTORequest);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(purchaseDTOResponse.id()).toUri();
        return ResponseEntity.created(uri).body(purchaseDTOResponse);
    }
}
