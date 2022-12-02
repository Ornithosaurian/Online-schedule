package com.example.university.service;

import com.example.university.repository.FacultyRepository;
import org.springframework.stereotype.Service;


@Service
public class FacultyService extends BaseService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        super(facultyRepository);
        this.facultyRepository = facultyRepository;
    }
}
