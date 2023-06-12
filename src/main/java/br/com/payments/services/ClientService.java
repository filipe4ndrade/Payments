package br.com.payments.services;

import br.com.payments.models.enitities.Client;
import br.com.payments.models.dto.ClientDTO;
import br.com.payments.models.enitities.User;
import br.com.payments.repositories.ClientRepository;
import br.com.payments.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientDTO createClient(ClientDTO clientDTO){
        Client client = clientRepository.save(new Client(clientDTO));

        String password = passwordEncoder.encode(clientDTO.password());
        userRepository.save(new User(clientDTO.email(), password));

        return new ClientDTO(client);

    }

    public void deleteClient(Long id) {
        Client client = clientRepository.getReferenceById(id);
        try{
            clientRepository.deleteById(client.getId());
        }catch(EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Cliente não encontrado");
        }

    }

    public ClientDTO findClientById(long id) {
        Client client = clientRepository.getReferenceById(id);
        return new ClientDTO(client);
    }
}
