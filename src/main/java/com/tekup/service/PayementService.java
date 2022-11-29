package com.tekup.service;

import java.util.List;
import java.util.Optional;

import com.tekup.repository.PaymentRepository;
import com.tekup.model.Payement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.PayementDto;
import com.tekup.service.interfaces.PayementServiceInterface;

@Service
public class PayementService implements PayementServiceInterface{

	@Autowired
	PaymentRepository repository;
	@Override
	public PayementDto save(PayementDto entity) {
		Payement payement = PayementDto.toEntity(entity);
		repository.save(payement);
		PayementDto dto = PayementDto.fromEntity(payement);
		return dto;
	}

	@Override
	public List<PayementDto> findAll() {
		return PayementDto.fromListEntity(repository.findAll());
	}


	@Override
	public PayementDto update(Long id, PayementDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public PayementDto findById(Long id) {
		Optional<Payement> optional = repository.findById(id);
		if (optional.isPresent()) {
			Payement payement = optional.get();
			return PayementDto.fromEntity(payement);
		}
		return null;
	}

	

}
