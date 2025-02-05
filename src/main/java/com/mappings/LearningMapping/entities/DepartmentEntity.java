package com.mappings.LearningMapping.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @OneToOne
    @JoinColumn(name = "department_manager")
    private EmployeeEntity manager;
    @OneToMany(mappedBy = "workerDepartment")
    private Set<EmployeeEntity> worker;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DepartmentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
