package com.voiture.v1.controller;

import com.voiture.v1.entity.Employee;
import com.voiture.v1.enums.Role;
import com.voiture.v1.service.EmployeeServiceimp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class Employeecontroller {

    private final EmployeeServiceimp employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployee(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            employee.setIdEmployee(id);
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Employee> updateRole(@PathVariable Long id, @RequestParam Role role) {
        try {
            Employee updatedEmployee = employeeService.updaterole(id, role);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/phone/{id}")
    public ResponseEntity<Employee> updatePhone(@PathVariable Long id, @RequestParam String phone) {
        try {
            Employee updatedEmployee = employeeService.updatephone(id, phone);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
