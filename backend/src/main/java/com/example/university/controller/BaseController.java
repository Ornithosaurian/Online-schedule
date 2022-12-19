package com.example.university.controller;

import com.example.university.model.Model;
import com.example.university.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public abstract class BaseController {
    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping()
    public ResponseEntity<List<Model>> getAll() {
        List<Model> facultiesList = baseService.getAll();
        if (facultiesList.isEmpty()) {
            return new ResponseEntity<>(facultiesList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(facultiesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public abstract ResponseEntity<Model> getById(@PathVariable("id") long id);

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody Model model) {
        baseService.save(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public abstract ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody Model model);


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        baseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
