package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tekup.Validation.ManagerValidator;
import com.tekup.dto.ManagerDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Manager;
import com.tekup.model.Manager;
import com.tekup.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekup.dto.ManagerDto;
import com.tekup.service.interfaces.ManagerServiceInterface;

@Service
@Slf4j
public class ManagerService implements ManagerServiceInterface{

	 @Autowired
	ManagerRepository repository;

	@Override
	public ResponseEntity<ManagerDto> save(ManagerDto entityDto) {
		List<String> errors = ManagerValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("Manager is not valid {}", entityDto);
			throw new InvalidEntityException("The Manager is invalid", ErrorCodes.MANAGER_NOT_VALID, errors);
		}

		return ResponseEntity.ok(ManagerDto.fromEntity(repository.save(
				ManagerDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<ManagerDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(ManagerDto::fromEntity)
				.collect(Collectors.toList()));
	}





	@Override
	public ResponseEntity<ManagerDto> findById(Long id) {
		if (id == null) {
			log.error("Manager ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(ManagerDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Manager with ID = " + id + " was not found in the DataBase", ErrorCodes.MANAGER_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Manager ID is null");
			throw new InvalidOperationException("Unable to delete a Manager with a NULL ID",ErrorCodes.MANAGER_CODE_IS_NULL);
		}

		Manager entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Manager with ID = " + id + " was not found in the DataBase", ErrorCodes.MANAGER_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}
}
