package com.example.test.bootstrap;

import com.example.test.model.Chef;
import com.example.test.model.Dish;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class DataHolder {

    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init(){
        dishes.add(new Dish("1", "Pasta Carbonara", "Italian", 25));
        dishes.add(new Dish("2", "Beef Wellington", "British", 45));
        dishes.add(new Dish("3", "Chicken Tikka Masala", "Indian", 30));
        dishes.add(new Dish("4", "Sushi", "Japanese", 20));
        dishes.add(new Dish("5", "Moussaka", "Greek", 40));

        chefs.add(new Chef(1L, "Gordon", "Ramsay", "World-renowned chef with 16 Michelin stars"));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "British chef and restaurateur"));
        chefs.add(new Chef(3L, "Massimo", "Bottura", "Italian chef famous for Osteria Francescana"));
        chefs.add(new Chef(4L, "Heston", "Blumenthal", "Known for his scientific approach to cooking"));
        chefs.add(new Chef(5L, "Thomas", "Keller", "American chef, perfectionist and restaurateur"));
    }
}
