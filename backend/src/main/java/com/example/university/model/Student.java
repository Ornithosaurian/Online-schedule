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
public class Student extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(64)")
    private String surname;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String patronymic;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(13)")
    private String phone;
}
