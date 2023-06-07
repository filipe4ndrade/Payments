package br.com.payments.controllers;

import br.com.payments.models.dto.InvoiceDTO;
import br.com.payments.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Cacheable(value = "getInvoices")
    @GetMapping("/{id}")
    public ResponseEntity<List<InvoiceDTO>> getInvoice(@PathVariable Long id){
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @CacheEvict(value = "getInvoices")
    @PostMapping()
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTORequest,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        InvoiceDTO invoiceDTOResponse = invoiceService.createInvoice(invoiceDTORequest);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(invoiceDTOResponse.id()).toUri();
        return ResponseEntity.created(uri).body(invoiceDTOResponse);
    }
}
