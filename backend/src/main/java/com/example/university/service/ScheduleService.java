package com.example.university.service;

import com.example.university.model.Schedule;
import com.example.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService extends BaseService<Schedule, ScheduleRepository> {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        super(scheduleRepository);
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> sortByGroupAndDay(@Param("group") String groupName,
                                            @Param("day") String day) {
        return scheduleRepository.selectByGroupAndDay(groupName, day);
    }
}
