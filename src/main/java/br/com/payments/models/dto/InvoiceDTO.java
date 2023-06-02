package br.com.payments.models.dto;

import br.com.payments.models.invoice.Invoice;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record InvoiceDTO(


        Long id,
        @NotBlank
        LocalDate dueDate,

        @NotBlank
        String barcode,

        @NotBlank
        Long amount,

        @NotBlank
        boolean paid,

        @NotBlank
        Long contractNumber) {

    public InvoiceDTO(Invoice invoice) {
        this(invoice.getId(),invoice.getDueDate(), invoice.getBarcode(), invoice.getAmount(), invoice.isPaid(),
                invoice.getContractNumber());
    }

}

