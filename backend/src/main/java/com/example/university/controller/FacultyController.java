package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Faculty;
import com.example.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin("http://localhost:5173")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping()
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> facultiesList = facultyService.getFacultiesList();
        if (facultiesList.isEmpty()) {
            return new ResponseEntity<>(facultiesList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(facultiesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getNewsById(@PathVariable("id") long id) {
        Faculty faculty = facultyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Faculty with id = " + id));
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createNews(@RequestBody Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateNews(@PathVariable("id") long id, @RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Faculty with id = " + id));

        updatedFaculty.setName(faculty.getName());
        updatedFaculty.setShortName(faculty.getShortName());
        updatedFaculty.setDescription(faculty.getDescription());
        updatedFaculty.setImgSrc(faculty.getImgSrc());
        updatedFaculty.setDepartments(faculty.getDepartments());

        facultyService.saveFaculty(updatedFaculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNews(@PathVariable("id") long id) {
        facultyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
