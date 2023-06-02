package br.com.payments.models.transaction;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.dto.TransactionDTO;
import br.com.payments.models.enums.PaymentTypeEnum;
import br.com.payments.models.enums.StatusEnum;
import br.com.payments.models.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Table(name="transactions")
@Entity(name="Transaction")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Long authorizationCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Purchase purchase;

    private Integer installment;

    public Transaction(TransactionDTO transactionDTO, Purchase purchase){
        this.setCreateAt(LocalDate.now());
        this.paymentType = transactionDTO.paymentType();
        this.status = getRandomStatusEnum();
        this.authorizationCode = transactionDTO.authorizationCode();
        this.purchase = purchase;
    }

    private StatusEnum getRandomStatusEnum() {
        StatusEnum[] values = StatusEnum.values();
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }
}
