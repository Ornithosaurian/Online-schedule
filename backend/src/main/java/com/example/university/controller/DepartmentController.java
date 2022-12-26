package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Department;
import com.example.university.model.Faculty;
import com.example.university.model.Model;
import com.example.university.model.UnGroup;
import com.example.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController extends BaseController{

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        super(departmentService);
        this.departmentService = departmentService;
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Department department = (Department) departmentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Department.class + " with id = " + id));
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        Department updatedDepartment = (Department) departmentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Department.class + " with id = " + id));
        Department department = (Department) model;

        updatedDepartment.setName(department.getName());
        updatedDepartment.setShortName(department.getShortName());
        updatedDepartment.setDescription(department.getDescription());
        updatedDepartment.setImgSrc(department.getImgSrc());

        departmentService.save(updatedDepartment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addGroup/{id}")
    public ResponseEntity<HttpStatus> addDepartment(@PathVariable("id") long id, @RequestBody UnGroup group) {
        Department department = (Department) departmentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Department.class + " with id = " + id));
        department.addGroup(group);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
