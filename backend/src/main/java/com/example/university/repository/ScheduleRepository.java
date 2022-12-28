package com.example.university.repository;

import com.example.university.model.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends BaseRepository<Schedule> {

    @Query(value = "select s from Schedule s " +
            "join s.group ug " +
            "where ug.name = :group")
    List<Schedule> selectByGroupAndDay(@Param("group") String groupName);


    @Query(value = "select s from Schedule s " +
            "join s.group ug " +
            "where ug.id = :group")
    List<Schedule> selectByGroupId(@Param("group") String groupName);

}
