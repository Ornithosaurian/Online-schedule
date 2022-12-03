package com.example.university.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition="VARCHAR(10)")
    private String ShortName;

    @Column(nullable = false, columnDefinition="TEXT")
    private String description;

    @Column(nullable = false, columnDefinition="TEXT")
    private String imgSrc;
}
