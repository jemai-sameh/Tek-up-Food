package com.tekup.service;

import java.util.List;
import java.util.Optional;

import com.tekup.dto.PlatDto;
import com.tekup.service.interfaces.model.Plat;
import com.tekup.repository.PlatRepository;
import com.tekup.service.interfaces.PlatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatService implements PlatServiceInterface {

	@Autowired
	PlatRepository  repository;

	@Override
	public PlatDto save(PlatDto entity) {
		Plat plat = PlatDto.toEntity(entity);
		repository.save(plat);
		PlatDto dto = PlatDto.fromEntity(plat);
		return dto;
	}

	@Override
	public List<PlatDto> findAll() {
		return PlatDto.fromListEntity(repository.findAll());
	}

	@Override
	public PlatDto update(Long id, PlatDto entity) {
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public PlatDto findById(Long id) {
		Optional<Plat> optional = repository.findById(id);
		if (optional.isPresent()) {
			Plat plat = optional.get();
			return PlatDto.fromEntity(plat);
		}
		return null;	}
}
