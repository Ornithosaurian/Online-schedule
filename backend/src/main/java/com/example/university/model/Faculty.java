package com.example.university.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Faculty extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String shortName;

    @Column(nullable = false, columnDefinition="TEXT")
    private String description;

    @Column(nullable = false, columnDefinition="TEXT")
    private String imgSrc;

    @OneToMany(targetEntity = Department.class)
    private List<Department> departments;
}
