package br.com.payments.models.purchase;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.client.Client;
import br.com.payments.models.dto.PurchaseDTO;
import br.com.payments.models.invoice.Invoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name="purchases")
@Entity(name="Purchase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase extends BaseEntity{

    private Long amount;

    private Long invoiceAmount;

    private Double rate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "purchase_client", joinColumns=@JoinColumn(name = "purchase_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"))
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "purchase_invoice", joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"))
    private List<Invoice> invoices;

    // private Transaction transaction;

    public Purchase(PurchaseDTO purchaseDTO, Client client, List<Invoice> invoices){
        this.setId(purchaseDTO.id());
        this.setCreateAt(LocalDate.now());
        this.amount = purchaseDTO.amount();
        this.invoiceAmount = purchaseDTO.invoiceAmount();
        this.rate = purchaseDTO.rate();
        this.client = client;
        this.invoices = invoices;
    }
}
