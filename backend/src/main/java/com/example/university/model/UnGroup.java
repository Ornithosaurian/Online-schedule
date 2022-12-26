package com.example.university.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Entity
@Table
public class UnGroup extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String course;

    @OneToMany(targetEntity = Student.class,
            cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
    private Department department;

    public void addStudent(Student student){
        students.add(student);
        student.setUnGroup(this);
    }

    public void removeStudent(Student student){
        students.remove(student);
        student.setUnGroup(this);
    }
}
