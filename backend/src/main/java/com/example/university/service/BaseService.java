package com.example.university.service;

import com.example.university.model.Faculty;
import com.example.university.model.Model;
import com.example.university.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public abstract class BaseService {
    private final BaseRepository baseRepository;

    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<Model> getAll() {
        return baseRepository.findAll();
    }

    public void save(Model model) {
        baseRepository.save(model);
    }

    public Optional<Faculty> findById(long id) {
        return baseRepository.findById(id);
    }

    public void deleteById(long id) {
        baseRepository.deleteById(id);
    }
}
