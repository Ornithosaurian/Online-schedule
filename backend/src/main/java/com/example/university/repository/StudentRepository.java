package com.example.university.repository;

import com.example.university.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends BaseRepository<Student>{

//    @Query(value = "delete s, g from Student as s join un_group_students as g where s.id = :id and g.student_id = :id")
//    void deleteById(@Param("id") long id);
}
