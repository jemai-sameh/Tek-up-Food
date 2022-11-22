package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.service.interfaces.model.DeliveryMan;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {

}
