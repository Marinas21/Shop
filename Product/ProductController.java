package com.Andrei.ShopWebService.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    //On this line we create a new object that will help us in the future with the database connection
    private final JdbcTemplate jdbcTemplate;
    //Here we instantiate a constructor which take a jdbctemplate as parameter and give it to the object
    //we created early
    @Autowired
    public ProductController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

}
