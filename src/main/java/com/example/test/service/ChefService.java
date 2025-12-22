package com.example.test.service;

import com.example.test.model.Chef;
import com.example.test.model.Dish;

import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
}
