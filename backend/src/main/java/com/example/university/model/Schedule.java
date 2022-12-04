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
public class Schedule extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnGroup group;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String time;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String classroom;
}
