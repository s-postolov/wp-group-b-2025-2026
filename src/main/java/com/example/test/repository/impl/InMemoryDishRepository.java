package com.example.test.repository.impl;

import com.example.test.bootstrap.DataHolder;
import com.example.test.model.Dish;
import com.example.test.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryDishRepository implements DishRepository {
    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.
                stream().
                filter(dish -> dish.getDishId().equals(dishId)).
                findFirst().
                orElseThrow();
    }
}
