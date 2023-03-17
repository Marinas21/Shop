package com.Andrei.ShopWebService.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//This class it's responsible for all the listeners which involves the concept of product
@Controller
public class ProductController {
    // verificat daca produsele exista si daca categoriile exista
    //in cazul in care nu exista categorii se pot intoarce erori
    //gasit aceste situatii posibile si rezolvat

    //On this line we create a new object that will help us in the future with the database connection
    private final JdbcTemplate jdbcTemplate;
    //Here we instantiate a constructor which take a jdbctemplate as parameter and give it to the object
    //we created early
    @Autowired
    public ProductController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @GetMapping("/createProduct")
    public String createProduct(@RequestParam(name="name")String name,
                                @RequestParam(name="categoryId")String categoryId,
                                @RequestParam(name="price")String price){
        return ProductData.createProduct(jdbcTemplate,name,categoryId,price);
    }

    //Here we send a request to get all the products in the database
    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return ProductUtility.getAllProducts(jdbcTemplate);
    }

    //Here we send a request to get all the products that have the same, specific category
    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(@RequestParam(name="categoryId")String categoryId){
        return ProductUtility.getAllProductsByCategory(jdbcTemplate,categoryId);
    }

    //Here we send a request to get a specific product based on id
    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam(name="id")String id){
        return ProductData.getProductById(jdbcTemplate,id);
    }

    //Here we send a request to delete a specific product based on id
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(name="id")String id){
        return ProductData.deleteProduct(jdbcTemplate,id);
    }

    //here we send a request to change the name of the product based on id
    @GetMapping("/changeProductName")
    public String changeProductName(@RequestParam(name="id")String id,@RequestParam(name="name")String name){
        return ProductData.changeProductName(jdbcTemplate,id,name);
    }

    //here we send a request to change the price of the product based on id
    @GetMapping("/changeProductPrice")
    public String changeProductPrice(@RequestParam(name="id")String id,@RequestParam(name="price")String price){
        return ProductData.changeProductPrice(jdbcTemplate,id,price);
    }

    //here we send a request to change the category of the product based on id
    @GetMapping("/changeProductCategoryId")
    public String changeProductCategoryId(@RequestParam(name="id")String id,@RequestParam(name="categoryId")String categoryId){
        return ProductData.changeProductCategory(jdbcTemplate,id,categoryId);
    }
}
