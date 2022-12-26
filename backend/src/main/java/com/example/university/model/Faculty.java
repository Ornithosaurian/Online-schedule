package com.example.university.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Faculty extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String shortName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imgSrc;

    @OneToMany(targetEntity = Department.class,
            cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
        department.setFaculty(this);
    }

    public void removeDepartment(Department department){
        departments.remove(department);
        department.setFaculty(null);
    }
}
