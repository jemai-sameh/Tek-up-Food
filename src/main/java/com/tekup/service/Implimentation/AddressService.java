package com.tekup.service.Implimentation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tekup.Validation.AddressValidator;
import com.tekup.dto.AddressDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Address;
import com.tekup.repository.AddressRepository;
import com.tekup.service.interfaces.AddressServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddressService implements AddressServiceInterface {

	@Autowired
	AddressRepository repository;

	@Override
	public ResponseEntity<AddressDto> save(AddressDto entityDto) {
		List<String> errors = AddressValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("Address is not valid {}", entityDto);
			throw new InvalidEntityException("The Address is invalid", ErrorCodes.ADDRESS_NOT_VALID, errors);
		}

		return ResponseEntity.ok(AddressDto.fromEntity(repository.save(
				AddressDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<AddressDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(AddressDto::fromEntity)
				.collect(Collectors.toList()));
	}





	@Override
	public ResponseEntity<AddressDto> findById(Long id) {
		if (id == null) {
			log.error("Address ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(AddressDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Address with ID = " + id + " was not found in the DataBase", ErrorCodes.ADDRESS_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Address ID is null");
			throw new InvalidOperationException("Unable to delete a Address with a NULL ID",ErrorCodes.ADDRESS_CODE_IS_NULL);
		}

		Address entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Address with ID = " + id + " was not found in the DataBase", ErrorCodes.ADDRESS_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}



}