package com.tekup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tekup.dto.OrderDto;
import com.tekup.service.interfaces.OrderServiceInterface;

@Service
public class OrderService implements OrderServiceInterface{

	@Override
	public OrderDto save(OrderDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto update(Long id, OrderDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
