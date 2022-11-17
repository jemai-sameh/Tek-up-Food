package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.model.Commande;

@Repository
public interface OrderRepository extends JpaRepository<	Commande, Long>{

}
