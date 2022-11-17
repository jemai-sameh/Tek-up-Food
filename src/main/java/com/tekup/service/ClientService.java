package com.tekup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.ClientDto;
import com.tekup.model.Client;
import com.tekup.repository.ClientRepository;


@Service
public class ClientService implements GenericInterface<ClientDto>{
	
	@Autowired
	ClientRepository clientRepository;
	


	@Override
	public ClientDto save(ClientDto entity) {

		Client client=ClientDto.toEntity(entity);
		clientRepository.save(client);
		ClientDto dto=ClientDto.fromEntity(client);
		return dto;
		}



	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ClientDto update(Long id, ClientDto entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public ClientDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
