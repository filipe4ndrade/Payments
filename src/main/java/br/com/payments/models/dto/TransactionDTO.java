package br.com.payments.models.dto;

import br.com.payments.models.enums.PaymentTypeEnum;
import br.com.payments.models.enums.StatusEnum;
import br.com.payments.models.enitities.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record TransactionDTO(

        Long id,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        PaymentTypeEnum paymentType,

        @NotBlank(message = "O campo não pode estar vazio ou nulo")
        StatusEnum status,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long authorizationCode,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long installment,

        @NotEmpty(message = "O campo não pode estar vazio ou nulo")
        Long purchaseId
) {

    public TransactionDTO(Transaction transaction) {
        this(transaction.getId(),transaction.getPaymentType(), transaction.getStatus() , transaction.getAuthorizationCode(), transaction.getInstallment(),
                transaction.getPurchase().getId());

    }
}

