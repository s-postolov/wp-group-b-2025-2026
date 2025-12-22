package com.example.test.repository.impl;

import com.example.test.bootstrap.DataHolder;
import com.example.test.model.Chef;
import com.example.test.repository.ChefRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository {
    @Override
    public List<Chef> findAll(){
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return DataHolder.chefs.
                stream().
                filter(chef -> chef.getId().equals(id)).
                findFirst();
    }

    @Override
    public Chef save(Chef chef) {
        DataHolder.chefs.removeIf( c -> c.getId().equals(chef.getId()));
        DataHolder.chefs.add(chef);
        return chef;
    }
}
