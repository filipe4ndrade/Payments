package br.com.payments.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "uuid", updatable = false)
    private UUID UUID;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate removeAt;

    @PrePersist
    private void generateUUID() {
        this.UUID = UUID.randomUUID();
    }

}
