package com.voiture.v1.repository;

import com.voiture.v1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Long> {
}
