package com.example.test.service.impl;

import com.example.test.model.Chef;
import com.example.test.model.Dish;
import com.example.test.repository.ChefRepository;
import com.example.test.repository.DishRepository;
import com.example.test.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService{
    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElseThrow();
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chef = findById(chefId);
        Dish dish = dishRepository.findByDishId(dishId);

        if(chef!=null && dish!=null){
            chef.getDishes().add(dish);
            return chefRepository.save(chef);
        }

        return null;
    }
}
