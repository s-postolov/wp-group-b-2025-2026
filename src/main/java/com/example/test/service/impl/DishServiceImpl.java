package com.example.test.service.impl;

import com.example.test.model.Dish;
import com.example.test.repository.DishRepository;
import com.example.test.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId){
        return dishRepository.findByDishId(dishId);
    }
}
