package com.example.test.web;

import com.example.test.service.ChefService;
import org.springframework.stereotype.Controller;

@Controller
public class DishServlet {

    private final ChefService chefService;

    public DishServlet(ChefService chefService) {
        this.chefService = chefService;
    }


}
