package br.com.payments.models.dto;

import br.com.payments.models.enums.PaymentTypeEnum;
import br.com.payments.models.enums.StatusEnum;
import br.com.payments.models.transaction.Transaction;

import java.util.UUID;

public record TransactionDTO(

        Long id,

        PaymentTypeEnum paymentType,

        StatusEnum status,

        Long authorizationCode,

        Integer installment,

        Long purchase_id
) {

    public TransactionDTO(Transaction transaction) {
        this(transaction.getId(),transaction.getPaymentType(), transaction.getStatus() , transaction.getAuthorizationCode(), transaction.getInstallment(),
                transaction.getPurchase().getId());

    }
}

