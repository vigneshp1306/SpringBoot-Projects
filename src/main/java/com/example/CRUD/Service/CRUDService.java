package com.example.CRUD.Service;

import com.example.CRUD.Model.CRUDEntity;
import com.example.CRUD.Repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDService {

    @Autowired
    private CRUDRepository repository;

    public CRUDEntity create(CRUDEntity entity) {
        return repository.save(entity);
    }

    public List<CRUDEntity> getAll() {
        return repository.findAll();
    }

    public Optional<CRUDEntity> getById(Long id) {
        return repository.findById(id);
    }

    public CRUDEntity update(Long id, CRUDEntity updatedData) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedData.getName());
                    existing.setEmail(updatedData.getEmail());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}