package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.tekup.Validation.DeliveryManValidator;
import com.tekup.dto.DeliveryManDto;
import com.tekup.dto.DeliveryManDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.DeliveryMan;
import com.tekup.model.DeliveryMan;
import com.tekup.repository.DeliveryManRepository;
import com.tekup.model.DeliveryMan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.DeliveryManDto;
import com.tekup.service.interfaces.DeliveryManServiceInterface;

@Service
@Slf4j
public class DeliveryManService implements DeliveryManServiceInterface{

	@Autowired
	DeliveryManRepository repository;


	@Override
	public ResponseEntity<DeliveryManDto> save(DeliveryManDto entityDto) {
		List<String> errors = DeliveryManValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("DeliveryMan is not valid {}", entityDto);
			throw new InvalidEntityException("The DeliveryMan is invalid", ErrorCodes.DELIVERY_MAN_NOT_VALID, errors);
		}

		return ResponseEntity.ok(DeliveryManDto.fromEntity(repository.save(
				DeliveryManDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<DeliveryManDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(DeliveryManDto::fromEntity)
				.collect(Collectors.toList()));
	}





	@Override
	public ResponseEntity<DeliveryManDto> findById(Long id) {
		if (id == null) {
			log.error("DeliveryMan ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(DeliveryManDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No DeliveryMan with ID = " + id + " was not found in the DataBase", ErrorCodes.DELIVERY_MAN_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("DeliveryMan ID is null");
			throw new InvalidOperationException("Unable to delete a DeliveryMan with a NULL ID",ErrorCodes.DELIVERY_MAN_CODE_IS_NULL);
		}

		DeliveryMan entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No DeliveryMan with ID = " + id + " was not found in the DataBase", ErrorCodes.DELIVERY_MAN_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}

	

}
