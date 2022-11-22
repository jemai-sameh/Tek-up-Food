package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.service.interfaces.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
