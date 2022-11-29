package com.tekup.service;
import java.util.List;
import java.util.Optional;

import com.tekup.dto.AddressDto;
import com.tekup.model.Address;
import com.tekup.repository.AddressRepository;
import com.tekup.service.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService implements AddressServiceInterface {

	@Autowired
	AddressRepository repository;

	@Override
	public AddressDto save(AddressDto entity) {
		Address address = AddressDto.toEntity(entity);
		repository.save(address);
		AddressDto dto = AddressDto.fromEntity(address);
		return dto;
	}

	@Override
	public List<AddressDto> findAll() {
		return AddressDto.fromListEntity(repository.findAll());
	}



	@Override
	public AddressDto update(Long id, AddressDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public AddressDto findById(Long id) {
		Optional<Address> optional = repository.findById(id);
		if (optional.isPresent()) {
			Address address = optional.get();
			return AddressDto.fromEntity(address);
		}
		return null;
	}



}