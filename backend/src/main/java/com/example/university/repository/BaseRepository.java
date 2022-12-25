package com.example.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Model extends com.example.university.model.Model> extends JpaRepository<Model, Long> {
}
