package com.example.university.service;

import com.example.university.model.Faculty;
import com.example.university.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyService extends BaseService<Faculty, FacultyRepository> {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        super(facultyRepository);
        this.facultyRepository = facultyRepository;
    }
}
