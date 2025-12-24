package com.example.test.web;

import com.example.test.model.Chef;
import com.example.test.model.Dish;
import com.example.test.service.ChefService;
import com.example.test.service.DishService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;

    public ChefDetailsServlet(DishService dishService, ChefService chefService, SpringTemplateEngine springTemplateEngine) {
        this.dishService = dishService;
        this.chefService = chefService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);

        WebContext context = new WebContext(webExchange);
        Long chefId = Long.parseLong(request.getParameter("chefId"));
        context.setVariable("chef", chefService.findById(chefId));

        springTemplateEngine.process("chefDetails.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long chefId = Long.parseLong(request.getParameter("chefId"));
        String dishId = request.getParameter("dishId");

        Chef chef = chefService.findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        if (chef != null && dish != null) {
            chefService.addDishToChef(chefId, dishId);
        }

        response.sendRedirect("/chefDetails?chefId="+chefId);
    }
}
