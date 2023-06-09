package br.com.payments.models.dto;

import br.com.payments.models.enitities.Invoice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record InvoiceDTO(


        Long id,
        @NotNull(message = "O campo não pode estar vazio ou nulo")
        LocalDate dueDate,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String barcode,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Long amount,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        boolean paid,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Long contractNumber) {

    public InvoiceDTO(Invoice invoice) {
        this(invoice.getId(),invoice.getDueDate(), invoice.getBarcode(), invoice.getAmount(), invoice.isPaid(),
                invoice.getContractNumber());
    }

}

