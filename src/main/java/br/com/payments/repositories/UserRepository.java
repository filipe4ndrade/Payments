package br.com.payments.repositories;

import br.com.payments.models.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByLogin(String login);
}
