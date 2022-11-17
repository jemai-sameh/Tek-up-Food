package com.tekup.service.interfaces;
import java.util.List;


public interface GenericInterface<T> {
	T save(T entity);

	List<T> findAll();

	T update(Long id, T entity);

	void deleteById(Long id);

	T findById(Long id);


}