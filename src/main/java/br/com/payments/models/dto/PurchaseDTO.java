package br.com.payments.models.dto;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.enitities.Purchase;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PurchaseDTO(

        Long id,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Long amount,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Long invoiceAmount,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Double rate,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        Long client,

        @NotNull(message = "O campo não pode estar vazio ou nulo")
        List<Long> invoiceId) {

    public PurchaseDTO(Purchase purchase) {
        this(purchase.getId(), purchase.getAmount(), purchase.getInvoiceAmount(),purchase.getRate(),
                purchase.getClient().getId(), purchase.getInvoices().stream().map(BaseEntity::getId).toList());
    }

}