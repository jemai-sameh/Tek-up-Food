package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
