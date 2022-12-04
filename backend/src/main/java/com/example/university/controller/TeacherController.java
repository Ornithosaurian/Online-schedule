package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Model;
import com.example.university.model.News;
import com.example.university.model.Teacher;
import com.example.university.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController extends BaseController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        super(teacherService);
        this.teacherService = teacherService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Teacher teacher = (Teacher) teacherService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + News.class + " with id = " + id));
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        Teacher updatedTeacher = (Teacher) teacherService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + News.class + " with id = " + id));
        Teacher teacher = (Teacher) model;

        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setSurname(teacher.getSurname());
        updatedTeacher.setPatronymic(teacher.getPatronymic());
        updatedTeacher.setEmail(teacher.getEmail());
        updatedTeacher.setPhone(teacher.getPhone());

        teacherService.save(updatedTeacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
