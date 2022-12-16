package com.tekup.service.Implimentation;

import java.util.List;
import java.util.stream.Collectors;

import com.tekup.Validation.OrderValidator;
import com.tekup.dto.OrderDetailsDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Commande;
import com.tekup.model.Plat;
import com.tekup.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.OrderDto;
import com.tekup.service.interfaces.OrderServiceInterface;

@Service
@Slf4j
public class OrderService implements OrderServiceInterface{

	@Autowired
	OrderRepository repository;

	@Override
	public ResponseEntity<OrderDto> saveOrder(OrderDetailsDto entityDto) {
		List<String> errors = OrderValidator.validate(OrderDto.fromEntity(OrderDetailsDto.toEntity(entityDto)));
		for (String err:errors
			 ) {
			System.out.println(err);

		}
		if (!errors.isEmpty()) {
			log.error("Order is not valid {}", entityDto);
			throw new InvalidEntityException("The Order is invalid", ErrorCodes.ORDER_NOT_VALID, errors);
		}
		System.out.println(entityDto.getPaymentMethod());
		Commande order = OrderDetailsDto.toEntity(entityDto);
		System.out.println("++"+order.getPaymentMethod());
		for (Long id: entityDto.getPlatIds()) {
			//	System.err.println(id);
			Plat plat = new Plat();
			plat.setId(id);
			order.addPlat(plat);
		}


		return ResponseEntity.ok(OrderDto.fromEntity(repository.save(
				order
		)));

	}

	@Override
	public ResponseEntity<OrderDto> save(OrderDto entity) {
		return null;
	}

	@Override
	public ResponseEntity<List<OrderDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(OrderDto::fromEntity)
				.collect(Collectors.toList()));
	}


	@Override
	public ResponseEntity<OrderDto> findById(Long id) {
		if (id == null) {
			log.error("Order ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(OrderDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Order with ID = " + id + " was not found in the DataBase", ErrorCodes.ORDER_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Order ID is null");
			throw new InvalidOperationException("Unable to delete a Order with a NULL ID",ErrorCodes.ORDER_CODE_IS_NULL);
		}

		Commande entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Order with ID = " + id + " was not found in the DataBase", ErrorCodes.ORDER_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}

}
