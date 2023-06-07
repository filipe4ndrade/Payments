package br.com.payments.repositories;

import br.com.payments.models.enitities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Long> {

}
