package com.Andrei.ShopWebService.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    //On this line we create a new object that will help us in the future with the database connection
    private final JdbcTemplate jdbcTemplate;
    //Here we instantiate a constructor which take a jdbctemplate as parameter and give it to the object
    //we created early
    @Autowired
    public CategoryController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

}
