package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Group;
import com.example.university.model.Model;
import com.example.university.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
public class GroupController extends BaseController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        super(groupService);
        this.groupService = groupService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Group group = (Group) groupService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Group.class + " with id = " + id));
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") long id, @RequestBody Model model) {
        Group updatedGroup = (Group) groupService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Group.class + " with id = " + id));
        Group group = (Group) model;

        updatedGroup.setName(group.getName());
        updatedGroup.setCourse(group.getCourse());

        groupService.save(updatedGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
