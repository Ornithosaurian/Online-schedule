package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Model;
import com.example.university.model.Schedule;
import com.example.university.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
public class ScheduleController extends BaseController{

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
        this.scheduleService = scheduleService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        Schedule schedule = (Schedule) scheduleService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Schedule.class + " with id = " + id));
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        Schedule updatedSchedule = (Schedule) scheduleService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + Schedule.class + " with id = " + id));
        Schedule schedule = (Schedule) model;

        updatedSchedule.setName(schedule.getName());
        updatedSchedule.setTeacher(schedule.getTeacher());
        updatedSchedule.setDiscipline(schedule.getDiscipline());
        updatedSchedule.setGroup(schedule.getGroup());
        updatedSchedule.setTime(schedule.getTime());
        updatedSchedule.setClassroom(schedule.getClassroom());
        updatedSchedule.setDay(schedule.getDay());

        scheduleService.save(updatedSchedule);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Schedule>> sortByGroupAndDay(@Param("group") String group){
        List<Schedule> schedulesList = scheduleService.sortByGroupAndDay(group);
        if (schedulesList.isEmpty()) {
            return new ResponseEntity<>(schedulesList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(schedulesList, HttpStatus.OK);
    }

    @GetMapping("/sortByGroupName")
    public ResponseEntity<List<Schedule>> sortByGroupName(@Param("group") String group){
        List<Schedule> schedulesList = scheduleService.sortByGroupId(group);
        if (schedulesList.isEmpty()) {
            return new ResponseEntity<>(schedulesList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(schedulesList, HttpStatus.OK);
    }
}
