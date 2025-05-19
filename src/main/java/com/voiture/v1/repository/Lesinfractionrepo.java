package com.voiture.v1.repository;

import com.voiture.v1.entity.Lesinfraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lesinfractionrepo extends JpaRepository<Lesinfraction, Long> {

}
