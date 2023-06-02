package br.com.payments.repositories;

import br.com.payments.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
