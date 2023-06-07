package br.com.payments.models.dto;

import br.com.payments.models.enitities.Invoice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record InvoiceDTO(


        Long id,
        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        LocalDate dueDate,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        String barcode,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long amount,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        boolean paid,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long contractNumber) {

    public InvoiceDTO(Invoice invoice) {
        this(invoice.getId(),invoice.getDueDate(), invoice.getBarcode(), invoice.getAmount(), invoice.isPaid(),
                invoice.getContractNumber());
    }

}

