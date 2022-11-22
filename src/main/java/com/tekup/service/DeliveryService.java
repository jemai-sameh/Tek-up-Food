package com.tekup.service;

import java.util.List;
import java.util.Optional;


import com.tekup.model.Delivery;
import com.tekup.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.DeliveryDto;
import com.tekup.service.interfaces.DeliveryServiceInterface;

@Service
public class DeliveryService implements DeliveryServiceInterface{

	@Autowired
	DeliveryRepository repository;
	@Override
	public DeliveryDto save(DeliveryDto entity) {
		Delivery delivery = DeliveryDto.toEntity(entity);
		repository.save(delivery);
		DeliveryDto dto = DeliveryDto.fromEntity(delivery);
		return dto;
	}

	@Override
	public List<DeliveryDto> findAll() {
		return DeliveryDto.fromListEntity(repository.findAll());
	}

	@Override
	public DeliveryDto update(Long id, DeliveryDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public DeliveryDto findById(Long id) {
		Optional<Delivery> optional = repository.findById(id);
		if (optional.isPresent()) {
			Delivery delivery = optional.get();
			return DeliveryDto.fromEntity(delivery);
		}
		return null;

	}


}
