package com.example.university.service;

import com.example.university.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService extends BaseService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        super(disciplineRepository);
        this.disciplineRepository = disciplineRepository;
    }
}
