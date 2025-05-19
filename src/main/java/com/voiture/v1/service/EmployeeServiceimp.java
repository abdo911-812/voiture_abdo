package com.voiture.v1.service;

import com.voiture.v1.entity.Employee;
import com.voiture.v1.enums.Role;
import com.voiture.v1.repository.Employeerepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimp implements Employeeservice {
    private final Employeerepo employeeRepo;

    @Autowired
    public EmployeeServiceimp(Employeerepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee
    getEmployee(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee avec id " + id + " non trouvé"));
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        if (employee.getIdEmployee() == null || 
            !employeeRepo.existsById(employee.getIdEmployee())) {
            throw new RuntimeException("Employee avec id " + employee.getIdEmployee() + " non trouvé");
        }
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee avec id " + id + " non trouvé"));
        employeeRepo.deleteById(id);
        return employee;
    }

    @Override
    @Transactional
    public Employee updaterole(Long id, Role role) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee avec id " + id + " non trouvé"));
        employee.setRole(role);
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updatephone(Long id, String phone) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee avec id " + id + " non trouvé"));
        employee.setTelephone(phone);
        return employeeRepo.save(employee);
    }
}
