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
public class UnGroup extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String name;

    @Column(nullable = false, columnDefinition="VARCHAR(50)")
    private String course;
}
