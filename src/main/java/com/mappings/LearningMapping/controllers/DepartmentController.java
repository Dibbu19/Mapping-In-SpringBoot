package com.mappings.LearningMapping.controllers;

import com.mappings.LearningMapping.entities.DepartmentEntity;
import com.mappings.LearningMapping.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getEmployeeById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewEmployee(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment
             (@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping("/assign/manager/{employeeId}")
    public DepartmentEntity getAssignedDepartmentOfManager
            (@PathVariable Long employeeId) {
        return departmentService.getAssignedDepartmentOfManage(employeeId);
    }


    @PutMapping("/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment
            (@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.assignWorkerToDepartment(departmentId, employeeId);
    }
}
