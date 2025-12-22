package com.example.test.service;

import com.example.test.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}
