package com.Andrei.ShopWebService.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/getCategorys")
    public List<Category> getAllCategorys(){
        return CategoryUtility.getAllCategorys(jdbcTemplate);
    }

    @GetMapping("/getCategory")
    public Category getCategoryById(@RequestParam(name="id")String id){
        return CategoryUtility.getCategoryById(jdbcTemplate,id);
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name="id")String id){
        Category category=getCategoryById(id);
        if(category!=null){
            CategoryData.deleteCategoryById(jdbcTemplate,id);
            return "Category deleted";
        }
        return "Category does not exists";
    }

    @GetMapping("/deleteCategory")
    public String createCategory(@RequestParam(name="name")String name){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,name);
        if(category==null){
            CategoryData.createCategory(jdbcTemplate,name);
            return "Category created";
        }
        return "Category does exists";
    }

    public String updateCategoryName(@RequestParam(name="name")String name,@RequestParam(name="id")String id){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,name);
        if(category==null){
            CategoryData.changeCategoryName(jdbcTemplate,id,name);
            return "Category created";
        }
        return "Category does exists";
    }

}
