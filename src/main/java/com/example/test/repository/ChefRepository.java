package com.example.test.repository;
import com.example.test.model.Chef;
import java.util.List;
import java.util.Optional;

public interface ChefRepository {

    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
}
