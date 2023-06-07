package br.com.payments.models.dto;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.enitities.Purchase;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record PurchaseDTO(

        Long id,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long amount,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long invoiceAmount,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Double rate,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long client,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        List<Long> invoiceId) {

    public PurchaseDTO(Purchase purchase) {
        this(purchase.getId(), purchase.getAmount(), purchase.getInvoiceAmount(),purchase.getRate(),
                purchase.getClient().getId(), purchase.getInvoices().stream().map(BaseEntity::getId).toList());
    }

}