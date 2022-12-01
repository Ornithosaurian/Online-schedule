package com.example.university.repository;

import com.example.university.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "select n from News n order by n.date ASC")
    List<News> selectByNew();

    @Query(value = "select n from News n order by n.date DESC")
    List<News> selectByOld();
}
