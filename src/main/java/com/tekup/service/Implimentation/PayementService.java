package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tekup.Validation.PayementValidator;
import com.tekup.dto.PayementDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Payement;
import com.tekup.repository.PaymentRepository;
import com.tekup.model.Payement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.PayementDto;
import com.tekup.service.interfaces.PayementServiceInterface;

@Service
@Slf4j
public class PayementService implements PayementServiceInterface{

	@Autowired
	PaymentRepository repository;

	@Override
	public ResponseEntity<PayementDto> save(PayementDto entityDto) {
		List<String> errors = PayementValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("Payement is not valid {}", entityDto);
			throw new InvalidEntityException("The Payement is invalid", ErrorCodes.PAYEMENT_NOT_VALID, errors);
		}

		return ResponseEntity.ok(PayementDto.fromEntity(repository.save(
				PayementDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<PayementDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(PayementDto::fromEntity)
				.collect(Collectors.toList()));
	}





	@Override
	public ResponseEntity<PayementDto> findById(Long id) {
		if (id == null) {
			log.error("Payement ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(PayementDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Payement with ID = " + id + " was not found in the DataBase", ErrorCodes.PAYEMENT_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Payement ID is null");
			throw new InvalidOperationException("Unable to delete a Payement with a NULL ID",ErrorCodes.PAYEMENT_CODE_IS_NULL);
		}

		Payement entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Payement with ID = " + id + " was not found in the DataBase", ErrorCodes.PAYEMENT_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}

}
