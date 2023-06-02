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


    @Cacheable(value = "consultaDeInvoices")
    @GetMapping("/consulta/{id}")
    public ResponseEntity<List<InvoiceDTO>> consultarInvoice(@PathVariable Long id){
        return ResponseEntity.ok(invoiceService.consultarInvoice(id));
    }


    @CacheEvict(value = "consultaDeInvoices")
    @PostMapping("/cadastro")
    public ResponseEntity<InvoiceDTO> cadastrarInvoice(@RequestBody InvoiceDTO invoiceDTORequest,
                                                       UriComponentsBuilder uriComponentsBuilder) {
        InvoiceDTO invoiceDTOResponse = invoiceService.cadastrarInvoice(invoiceDTORequest);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(invoiceDTOResponse.id()).toUri();
        return ResponseEntity.created(uri).body(invoiceDTOResponse);
    }
}
