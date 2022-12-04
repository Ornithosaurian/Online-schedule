package com.example.university.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Entity
@Table
public class UnGroup extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition="VARCHAR(50)")
    private String course;

    @OneToMany(targetEntity = Student.class)
    private List<Student> students;
}
