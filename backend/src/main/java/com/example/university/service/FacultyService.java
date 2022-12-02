package com.example.university.service;

import com.example.university.model.Faculty;
import com.example.university.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getFacultiesList() {
        return facultyRepository.findAll();
    }

    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public Optional<Faculty> findById(long id) {
        return facultyRepository.findById(id);
    }

    public void deleteById(long id) {
        facultyRepository.deleteById(id);
    }
}
