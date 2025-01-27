package com.mappings.LearningMapping.controllers;

import com.mappings.LearningMapping.entities.EmployeeEntity;
import com.mappings.LearningMapping.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        if (employeeEntity.getName() == null) {
            throw new IllegalArgumentException("Employee name cannot be null");
        }
        return employeeService.createNewEmployee(employeeEntity);
    }
}
