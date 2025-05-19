package com.voiture.v1.service;

import com.voiture.v1.entity.Employee;
import com.voiture.v1.enums.Role;

import java.util.List;
import java.util.Optional;

public interface Employeeservice {

    public Employee getEmployee(Long id);
    public List<Employee> getEmployees();
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee(Long id);
    public Employee updaterole(Long id, Role role);
    public Employee updatephone(Long id, String phone);
}
