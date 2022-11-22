package com.tekup.service;

import java.util.List;
import java.util.Optional;


import com.tekup.dto.DeliveryDto;
import com.tekup.repository.DeliveryManRepository;
import com.tekup.service.interfaces.model.Delivery;
import com.tekup.service.interfaces.model.DeliveryMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.DeliveryManDto;
import com.tekup.service.interfaces.DeliveryManServiceInterface;

@Service
public class DeliveryManService implements DeliveryManServiceInterface{

	@Autowired
	DeliveryManRepository repository;

	@Override
	public DeliveryManDto save(DeliveryManDto entity) {
		DeliveryMan deliveryMan = DeliveryManDto.toEntity(entity);
		repository.save(deliveryMan);
		DeliveryManDto dto = DeliveryManDto.fromEntity(deliveryMan);
		return dto;
	}

	@Override
	public List<DeliveryManDto> findAll() {
		return DeliveryManDto.fromListEntity(repository.findAll());
	}

	@Override
	public DeliveryManDto update(Long id, DeliveryManDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public DeliveryManDto findById(Long id) {
		Optional<DeliveryMan> optional = repository.findById(id);
		if (optional.isPresent()) {
			DeliveryMan delivery = optional.get();
			return DeliveryManDto.fromEntity(delivery);
		}
		return null;
	}

	

}
