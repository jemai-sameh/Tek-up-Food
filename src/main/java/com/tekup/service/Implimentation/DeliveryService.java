package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.tekup.Validation.DeliveryValidator;
import com.tekup.dto.DeliveryDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Delivery;
import com.tekup.model.Delivery;
import com.tekup.repository.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.DeliveryDto;
import com.tekup.service.interfaces.DeliveryServiceInterface;

@Service
@Slf4j
public class DeliveryService implements DeliveryServiceInterface{

	@Autowired
	DeliveryRepository repository;

	@Override
	public ResponseEntity<DeliveryDto> save(DeliveryDto entityDto) {
		List<String> errors = DeliveryValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("Delivery is not valid {}", entityDto);
			throw new InvalidEntityException("The Delivery is invalid", ErrorCodes.DELIVERY_NOT_VALID, errors);
		}

		return ResponseEntity.ok(DeliveryDto.fromEntity(repository.save(
				DeliveryDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<DeliveryDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(DeliveryDto::fromEntity)
				.collect(Collectors.toList()));
	}





	@Override
	public ResponseEntity<DeliveryDto> findById(Long id) {
		if (id == null) {
			log.error("Delivery ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(DeliveryDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Delivery with ID = " + id + " was not found in the DataBase", ErrorCodes.DELIVERY_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Delivery ID is null");
			throw new InvalidOperationException("Unable to delete a Delivery with a NULL ID",ErrorCodes.DELIVERY_CODE_IS_NULL);
		}

		Delivery entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Delivery with ID = " + id + " was not found in the DataBase", ErrorCodes.DELIVERY_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}


}
