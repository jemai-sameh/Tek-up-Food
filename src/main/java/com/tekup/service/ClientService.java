package com.tekup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.ClientDto;
import com.tekup.model.Client;
import com.tekup.repository.ClientRepository;
import com.tekup.service.interfaces.ClientServiceInterface;


@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto entity) {

        Client client = ClientDto.toEntity(entity);
        clientRepository.save(client);
        ClientDto dto = ClientDto.fromEntity(client);
        return dto;
    }


    @Override
    public List<ClientDto> findAll() {
        return ClientDto.fromListEntity(clientRepository.findAll());
    }


    @Override
    public ClientDto update(Long id, ClientDto entity) {
        Client client = ClientDto.toEntity(entity);
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client clients = optionalClient.get();
            client.setFirstName(client.getFirstName());
            client.setLastName(client.getLastName());
            client.setPhoneNumber(client.getPhoneNumber());
            client.setMail(client.getMail());
            client.setPasswd(client.getPasswd());
            clientRepository.save(client);
            ClientDto updateClientDTO = ClientDto.fromEntity(clients);
            return updateClientDTO;
        }

        return null;


    }


    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }


    @Override
    public ClientDto findById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return ClientDto.fromEntity(client);
        }
        return null;

    }


}
