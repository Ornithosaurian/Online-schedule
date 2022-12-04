package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Discipline;
import com.example.university.model.Model;
import com.example.university.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController extends BaseController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        super(disciplineService);
        this.disciplineService = disciplineService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Discipline discipline = (Discipline) disciplineService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Discipline.class + " with id = " + id));
        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        Discipline updatedDiscipline = (Discipline) disciplineService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Discipline.class + " with id = " + id));
        Discipline discipline = (Discipline) model;

        updatedDiscipline.setName(discipline.getName());

        disciplineService.save(updatedDiscipline);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
