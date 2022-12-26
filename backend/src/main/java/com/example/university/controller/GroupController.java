package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Student;
import com.example.university.model.UnGroup;
import com.example.university.model.Model;
import com.example.university.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
public class GroupController extends BaseController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        super(groupService);
        this.groupService = groupService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        UnGroup group = (UnGroup) groupService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + UnGroup.class + " with id = " + id));
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody Model model) {
        UnGroup updatedGroup = (UnGroup) groupService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + UnGroup.class + " with id = " + id));
        UnGroup group = (UnGroup) model;

        updatedGroup.setName(group.getName());
        updatedGroup.setCourse(group.getCourse());

        groupService.save(updatedGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addStudent/{id}")
    public ResponseEntity<HttpStatus> addDepartment(@PathVariable("id") long id, @RequestBody Student student) {
        UnGroup group = (UnGroup) groupService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + UnGroup.class + " with id = " + id));
        group.addStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
