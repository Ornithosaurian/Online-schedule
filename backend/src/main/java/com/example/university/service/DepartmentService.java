package com.example.university.service;

import com.example.university.model.Department;
import com.example.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends BaseService<Department, DepartmentRepository> {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        super(departmentRepository);
        this.departmentRepository = departmentRepository;
    }
}
