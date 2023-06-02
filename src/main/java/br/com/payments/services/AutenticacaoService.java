package br.com.payments.services;


import br.com.payments.repositories.ClientRepository;
import br.com.payments.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AutenticacaoService implements UserDetailsService {

    private final UserRepository autenticacaoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return autenticacaoRepository.findByLogin(username);
    }
}
