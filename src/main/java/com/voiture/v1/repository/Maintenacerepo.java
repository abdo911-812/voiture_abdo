package com.voiture.v1.repository;

import com.voiture.v1.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Maintenacerepo extends JpaRepository<Maintenance,Long> {
}
