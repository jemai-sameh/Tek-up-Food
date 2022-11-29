package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.model.Plat;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Long> {

}
