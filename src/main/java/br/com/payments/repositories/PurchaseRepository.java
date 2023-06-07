package br.com.payments.repositories;

import br.com.payments.models.enitities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
