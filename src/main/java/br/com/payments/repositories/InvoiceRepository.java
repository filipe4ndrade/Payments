package br.com.payments.repositories;

import br.com.payments.models.enitities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByContractNumberAndPaidFalse(Long contractNumber);

}