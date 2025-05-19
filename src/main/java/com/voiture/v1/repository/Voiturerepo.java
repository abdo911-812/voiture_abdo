package com.voiture.v1.repository;

import com.voiture.v1.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Voiturerepo extends JpaRepository<Voiture, Long> {}