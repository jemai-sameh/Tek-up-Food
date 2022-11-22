package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.service.interfaces.model.Payement;


@Repository
public interface PaymentRepository  extends JpaRepository<Payement, Long> {

}