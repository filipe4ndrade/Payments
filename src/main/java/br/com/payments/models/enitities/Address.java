package br.com.payments.models.enitities;

import br.com.payments.models.BaseEntity;
import br.com.payments.models.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="addresses")
@Entity(name="Address")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

    private String street;
    private String number;
    private String city;
    private String state;
    private String complement;

    public Address(AddressDTO addressDTO){
        this.street = addressDTO.street();
        this.number = addressDTO.number();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.complement = addressDTO.complement();
    }
}
