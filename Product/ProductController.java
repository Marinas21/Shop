package com.Andrei.ShopWebService.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/createProduct")
    public String createProduct(@RequestParam(name="name")String name,
                                @RequestParam(name="categoryId")String categoryId,
                                @RequestParam(name="price")String price){
        return ProductData.createProduct(jdbcTemplate,name,categoryId,price);
    }
    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return ProductUtility.getAllProducts(jdbcTemplate);
    }
    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(@RequestParam(name="categoryId")String categoryId){
        return ProductUtility.getAllProductsByCategory(jdbcTemplate,categoryId);
    }
    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam(name="id")String id){
        return ProductData.getProductById(jdbcTemplate,id);
    }
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(name="id")String id){
        return ProductData.deleteProduct(jdbcTemplate,id);
    }
    @GetMapping("/changeProductName")
    public String changeProductName(@RequestParam(name="id")String id,@RequestParam(name="name")String name){
        return ProductData.changeProductName(jdbcTemplate,id,name);
    }
    @GetMapping("/changeProductPrice")
    public String changeProductPrice(@RequestParam(name="id")String id,@RequestParam(name="price")String price){
        return ProductData.changeProductPrice(jdbcTemplate,id,price);
    }
    @GetMapping("/changeProductCategoryId")
    public String changeProductCategoryId(@RequestParam(name="id")String id,@RequestParam(name="categoryId")String categoryId){
        return ProductData.changeProductCategory(jdbcTemplate,id,categoryId);
    }
}
