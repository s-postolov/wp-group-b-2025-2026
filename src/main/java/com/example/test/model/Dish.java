package com.example.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dish {
    String dishId;
    String name;
    String cuisine;
    int preparationTime;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }
}
