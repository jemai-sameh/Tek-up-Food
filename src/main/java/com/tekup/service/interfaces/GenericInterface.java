package com.tekup.service.interfaces;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface GenericInterface<T> {
	ResponseEntity<T> save(T entity);

	ResponseEntity<List<T>> findAll();


	ResponseEntity<Void> deleteById(Long id);

	ResponseEntity<T> findById(Long id);


}