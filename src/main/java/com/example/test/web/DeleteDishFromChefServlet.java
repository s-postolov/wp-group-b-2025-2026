package com.example.test.web;

import com.example.test.model.Chef;
import com.example.test.model.Dish;
import com.example.test.service.ChefService;
import com.example.test.service.DishService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;

@WebServlet(name = "DeleteDishFromChefServlet", urlPatterns = "/deleteDishFromChef")
public class DeleteDishFromChefServlet extends HttpServlet {
    private final ChefService chefService;
    private final DishService dishService;
    private final SpringTemplateEngine springTemplateEngine;

    public DeleteDishFromChefServlet(ChefService chefService, DishService dishService, SpringTemplateEngine springTemplateEngine) {
        this.chefService = chefService;
        this.dishService = dishService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long chefId = Long.parseLong(request.getParameter("chefId"));
        String dishId = request.getParameter("dishId");

        Chef chef = chefService.findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        if(chef!=null && dish!=null){
            chefService.removeDishFromChef(chefId, dishId);
        }

        response.sendRedirect("/chefDetails?chefId=" + chefId);
    }
}
