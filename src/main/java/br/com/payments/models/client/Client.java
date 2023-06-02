package br.com.payments.models.client;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.address.Address;
import br.com.payments.models.dto.ClientDTO;
import br.com.payments.models.enums.ContractTypeEnum;

import br.com.payments.models.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table(name="clients")
@Entity(name="Client")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends BaseEntity implements Assignment {

    private  String name;

    @Column(unique = true)
    private  String identity;

    @Enumerated(EnumType.STRING)
    private ContractTypeEnum contract;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    private Long contractNumber;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Purchase> purchase;

    public Client(ClientDTO clientDTO){
        this.setCreateAt(LocalDate.now());
        this.name = clientDTO.name();
        this.identity = clientDTO.identity();
        this.contract = clientDTO.contract();
        this.email = clientDTO.email();
        this.password = clientDTO.password();
        this.address = new Address(clientDTO.address());
        this.contractNumber = clientDTO.contractNumber();
        this.purchase = new HashSet<>();
    }
    @Override
    public List<Double> getFees(ContractTypeEnum contractType) {
        return null;
    }
}

