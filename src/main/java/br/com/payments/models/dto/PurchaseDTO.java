package br.com.payments.models.dto;

import br.com.payments.models.purchase.Purchase;

import java.util.List;
import java.util.UUID;

public record PurchaseDTO(

        Long id,

        Long amount,

        Long invoiceAmount,

        Double rate,

        Long clientId,

        List<Long> invoiceId) {

    public PurchaseDTO(Purchase purchase) {
        this(purchase.getId(), purchase.getAmount(), purchase.getInvoiceAmount(),purchase.getRate(),
                purchase.getClient().getId(), purchase.getInvoices().stream().map((invoice)-> invoice.getId()).toList());
    }

}