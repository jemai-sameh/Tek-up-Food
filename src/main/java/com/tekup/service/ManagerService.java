package com.tekup.service;

import java.util.List;
import java.util.Optional;

import com.tekup.model.Manager;
import com.tekup.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.dto.ManagerDto;
import com.tekup.service.interfaces.ManagerServiceInterface;

@Service
public class ManagerService implements ManagerServiceInterface{

	 @Autowired
	ManagerRepository repository;
	@Override
	public ManagerDto save(ManagerDto entity) {
		Manager manager = ManagerDto.toEntity(entity);
		repository.save(manager);
		ManagerDto dto = ManagerDto.fromEntity(manager);
		return dto;
	}

	@Override
	public List<ManagerDto> findAll() {
		return ManagerDto.fromListEntity(repository.findAll());
	}


	@Override
	public ManagerDto update(Long id, ManagerDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public ManagerDto findById(Long id) {
		Optional<Manager> optional = repository.findById(id);
		if (optional.isPresent()) {
			Manager manager = optional.get();
			return ManagerDto.fromEntity(manager);
		}
		return null;
	}


}
