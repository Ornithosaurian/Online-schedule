package com.example.university.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter //FIXME
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

    @Column(nullable = false, columnDefinition="VARCHAR(10)")
    private String shortName;

    @Column(nullable = false, columnDefinition="TEXT")
    private String description;

    @Column(nullable = false, columnDefinition="TEXT")
    private String imgSrc;

    @OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL)
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
