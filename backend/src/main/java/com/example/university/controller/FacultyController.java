package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Faculty;
import com.example.university.model.Model;
import com.example.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/faculties")
public class FacultyController extends BaseController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        super(facultyService);
        this.facultyService = facultyService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Faculty faculty = (Faculty) facultyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Faculty.class.getSimpleName() + " with id = " + id));
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody Model model) {
        Faculty updatedFaculty = (Faculty) facultyService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Faculty.class.getSimpleName() + " with id = " + id));
        Faculty faculty = (Faculty) model;

        updatedFaculty.setName(faculty.getName());
        updatedFaculty.setShortName(faculty.getShortName());
        updatedFaculty.setDescription(faculty.getDescription());
        updatedFaculty.setImgSrc(faculty.getImgSrc());
        updatedFaculty.setDepartments(faculty.getDepartments());

        facultyService.save(updatedFaculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    public ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody Faculty faculty) {
//        Faculty updatedFaculty = facultyService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Not found Faculty with id = " + id));
//
//        updatedFaculty.setName(faculty.getName());
//        updatedFaculty.setShortName(faculty.getShortName());
//        updatedFaculty.setDescription(faculty.getDescription());
//        updatedFaculty.setImgSrc(faculty.getImgSrc());
//        updatedFaculty.setDepartments(faculty.getDepartments());
//
//        facultyService.saveFaculty(updatedFaculty);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @Override
//    @PutMapping("/{id}")
//    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
//        Faculty updatedFaculty = facultyService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Not found Faculty with id = " + id));
//
//        updatedFaculty.setName(faculty.getName());
//        updatedFaculty.setShortName(faculty.getShortName());
//        updatedFaculty.setDescription(faculty.getDescription());
//        updatedFaculty.setImgSrc(faculty.getImgSrc());
//        updatedFaculty.setDepartments(faculty.getDepartments());
//
//        facultyService.saveFaculty(updatedFaculty);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
