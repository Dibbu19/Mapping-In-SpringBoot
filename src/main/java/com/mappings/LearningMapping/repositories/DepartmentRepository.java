package com.mappings.LearningMapping.repositories;

import com.mappings.LearningMapping.entities.DepartmentEntity;
import com.mappings.LearningMapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
