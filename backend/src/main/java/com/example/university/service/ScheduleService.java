package com.example.university.service;

import com.example.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseService{

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        super(scheduleRepository);
        this.scheduleRepository = scheduleRepository;
    }
}
