package com.tekup.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.tekup.dto.OrderDetailsDto;
import com.tekup.dto.PlatDto;
import com.tekup.model.Commande;
import com.tekup.model.Plat;
import com.tekup.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.OrderDto;
import com.tekup.service.interfaces.OrderServiceInterface;

@Service
public class OrderService implements OrderServiceInterface{

	@Autowired
	OrderRepository repository;

	@Override
	public OrderDto saveOlder(OrderDetailsDto entity) {
		Commande order = OrderDetailsDto.toEntity(entity);
        for (Long id:entity.getPlatIds()) {
		//	System.err.println(id);
			Plat plat = new Plat();
			plat.setPlatID(id);
			order.addPlat(plat);
		}
		Commande saveOrder=repository.save(order);
		/*System.out.println("************************************");
		for (Plat p:saveOrder.getPlats()) {
			System.err.println(p.getPlatID());
			for (Commande c:p.getOrders()) {

				System.out.println(c.getOrderID());

			}
			System.out.println("---------------");

		}*/


		//OrderDto dto = OrderDto.fromEntity(order);
		OrderDto dto = OrderDto.fromEntity(saveOrder);

		return dto;
	}

	@Override
	public OrderDto save(OrderDto entity) {
		return null;
	}

	@Override
	public List<OrderDto> findAll() {return OrderDto.fromListEntity(repository.findAll());
	}


	@Override
	public OrderDto update(Long id, OrderDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public OrderDto findById(Long id) {
		Optional<Commande> optional = repository.findById(id);
		if (optional.isPresent()) {
			Commande order = optional.get();
			return OrderDto.fromEntity(order);
		}
		return null;
	}



}
