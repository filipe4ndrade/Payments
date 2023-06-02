package br.com.payments.services;

import br.com.payments.models.client.Client;
import br.com.payments.models.dto.ClientDTO;
import br.com.payments.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    //Cadastrar Clients
    public ClientDTO cadastrarClient(ClientDTO clientDTO){
        Client client = clientRepository.save(new Client(clientDTO));
        return new ClientDTO(client);

    }


    //Deletar Clients

    public void deletarClient(Long id) {
        Client client = clientRepository.getReferenceById(id);
        try{
            clientRepository.deleteById(client.getId());
        }catch(EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Cliente não encontrado");
        }

    }
}
