package com.tekup.service.Implimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tekup.Validation.PlatValidator;
import com.tekup.dto.PlatDto;
import com.tekup.dto.PlatDto;
import com.tekup.exception.EntityNotFoundException;
import com.tekup.exception.ErrorCodes;
import com.tekup.exception.InvalidEntityException;
import com.tekup.exception.InvalidOperationException;
import com.tekup.model.Plat;
import com.tekup.model.Plat;
import com.tekup.repository.PlatRepository;
import com.tekup.service.interfaces.PlatServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PlatService implements PlatServiceInterface {

	@Autowired
	PlatRepository  repository;


	@Override
	public ResponseEntity<PlatDto> save(PlatDto entityDto) {
		List<String> errors = PlatValidator.validate(entityDto);

		if (!errors.isEmpty()) {
			log.error("Plat is not valid {}", entityDto);
			throw new InvalidEntityException("The Plat is invalid", ErrorCodes.PLAT_NOT_VALID, errors);
		}

		return ResponseEntity.ok(PlatDto.fromEntity(repository.save(
				PlatDto.toEntity(entityDto)
		)));

	}
	@Override
	public ResponseEntity<List<PlatDto>> findAll() {
		return  ResponseEntity.ok(repository.findAll().stream()
				.map(PlatDto::fromEntity)
				.collect(Collectors.toList()));
	}


	@Override
	public ResponseEntity<PlatDto> findById(Long id) {
		if (id == null) {
			log.error("Plat ID is null");
			return null;
		}
		return  ResponseEntity.ok(repository.findById(id)
				.map(PlatDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"No Plat with ID = " + id + " was not found in the DataBase", ErrorCodes.PLAT_NOT_FOUND)
				));
	}
	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		if (id == null) {
			log.error("Plat ID is null");
			throw new InvalidOperationException("Unable to delete a Plat with a NULL ID",ErrorCodes.PLAT_CODE_IS_NULL);
		}

		Plat entity=repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				"No Plat with ID = " + id + " was not found in the DataBase", ErrorCodes.PLAT_NOT_FOUND)
		);
		repository.delete(entity);
		return  ResponseEntity.ok().build();
	}
}
