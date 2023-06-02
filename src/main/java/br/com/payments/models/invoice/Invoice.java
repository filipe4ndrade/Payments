package br.com.payments.models.invoice;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.dto.InvoiceDTO;
import br.com.payments.models.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name="invoices")
@Entity(name="Invoice")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity{

    private LocalDate dueDate = LocalDate.now();

    private String barcode;

    private Long amount;

    private boolean paid;

    private Long contractNumber;

    public Invoice(InvoiceDTO invoiceDTO){
        this.setCreateAt(LocalDate.now());
        this.dueDate = invoiceDTO.dueDate();
        this.barcode = invoiceDTO.barcode();
        this.amount = invoiceDTO.amount();
        this.paid = invoiceDTO.paid();
        this.contractNumber = invoiceDTO.contractNumber();
    }
}

