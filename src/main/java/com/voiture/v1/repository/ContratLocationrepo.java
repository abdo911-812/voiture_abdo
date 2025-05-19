package com.voiture.v1.repository;

import com.voiture.v1.entity.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratLocationrepo extends JpaRepository<ContratLocation,Long> {
}
