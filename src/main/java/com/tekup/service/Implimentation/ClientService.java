package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tekup.Validation.AddressValidator;
import com.tekup.Validation.ClientValidator;
import com.tekup.dto.AddressDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Address;
import com.tekup.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.ClientDto;
import com.tekup.model.Client;
import com.tekup.repository.ClientRepository;
import com.tekup.service.interfaces.ClientServiceInterface;


@Service
@Slf4j
public class ClientService implements ClientServiceInterface {

    @Autowired
    ClientRepository repository;


    @Override
    public ResponseEntity<ClientDto> save(ClientDto entityDto) {
        List<String> errors = ClientValidator.validate(entityDto);

        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", entityDto);
            throw new InvalidEntityException("The Client is invalid", ErrorCodes.ADDRESS_NOT_VALID, errors);
        }

        return ResponseEntity.ok(ClientDto.fromEntity(repository.save(
                ClientDto.toEntity(entityDto)
        )));

    }
    @Override
    public ResponseEntity<List<ClientDto>> findAll() {
        return  ResponseEntity.ok(repository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList()));
    }





    @Override
    public ResponseEntity<ClientDto> findById(Long id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return  ResponseEntity.ok(repository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No Client with ID = " + id + " was not found in the DataBase", ErrorCodes.ADDRESS_NOT_FOUND)
                ));
    }
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (id == null) {
            log.error("Client ID is null");
            throw new InvalidOperationException("Unable to delete a Client with a NULL ID",ErrorCodes.ADDRESS_CODE_IS_NULL);
        }

        Client entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No Client with ID = " + id + " was not found in the DataBase", ErrorCodes.ADDRESS_NOT_FOUND)
        );
        repository.delete(entity);
        return  ResponseEntity.ok().build();
    }

}
