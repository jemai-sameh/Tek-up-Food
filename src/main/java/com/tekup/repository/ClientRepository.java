package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
