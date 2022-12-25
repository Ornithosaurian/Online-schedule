package com.example.university.service;

import com.example.university.model.Model;
import com.example.university.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<M extends Model, R extends BaseRepository> {
    private final R R;

    @Autowired
    public BaseService(R Repository) {
        this.R = Repository;
    }

    public List<M> getAll() {
        return R.findAll();
    }

    public void save(M m) {
        R.save(m);
    }

    public Optional<M> findById(long id) {
        return R.findById(id);
    }

    public void deleteById(long id) {
        R.deleteById(id);
    }
}
