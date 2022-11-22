package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.service.interfaces.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long>{

}
