package com.voiture.v1.repository;

import com.voiture.v1.entity.EtatVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatVoiturerepo extends JpaRepository<EtatVoiture,Long> {
}
