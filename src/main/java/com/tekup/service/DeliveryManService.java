package com.tekup.service;

import java.util.List;


import com.tekup.repository.DeliveryManRepository;
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

		return  null;
	}

	@Override
	public List<DeliveryManDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryManDto update(Long id, DeliveryManDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeliveryManDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
