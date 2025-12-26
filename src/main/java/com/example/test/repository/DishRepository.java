package com.example.test.repository;

import com.example.test.model.Dish;

import java.util.List;

public interface DishRepository {

    List<Dish> findAll();
    Dish findByDishId(String dishId);
    Dish removeDishById(String dishId);
}
