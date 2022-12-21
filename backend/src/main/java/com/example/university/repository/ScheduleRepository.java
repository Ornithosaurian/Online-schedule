package com.example.university.repository;

import com.example.university.model.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends BaseRepository<Schedule, Long> {

    @Query(value = "select s from Schedule s " +
            "join s.group ug " +
            "where ug.name = :group and s.day=:day")
    List<Schedule> selectByGroupAndDay(@Param("group") String groupName,
                                        @Param("day") String day);
}
