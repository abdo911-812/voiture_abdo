package com.voiture.v1.repository;


import com.voiture.v1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Clientrepo extends JpaRepository<Client, Long> {
}
