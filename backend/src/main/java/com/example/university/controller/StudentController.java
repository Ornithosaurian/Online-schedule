package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Model;
import com.example.university.model.Student;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController extends BaseController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Student news = (Student) studentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Student.class + " with id = " + id));
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        Student updatedStudent = (Student) studentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Student.class + " with id = " + id));
        Student student = (Student) model;

        updatedStudent.setName(student.getName());
        updatedStudent.setSurname(student.getSurname());
        updatedStudent.setPatronymic(student.getPatronymic());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setPhone(student.getPhone());

        studentService.save(updatedStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
