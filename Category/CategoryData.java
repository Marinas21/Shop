package com.Andrei.ShopWebService.Category;

import org.springframework.jdbc.core.JdbcTemplate;

//This class it's responsible with action on a specific Object
public class CategoryData {

    //This method it's responsible with creating a new Category in the database
    //First we check if the name it's in use and if it is we return a message
    //that indicates this. If not we create the category and return a text.
    public static String createCategory(JdbcTemplate jdbcTemplate, String name){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,name);
        if(category!=null){
            return "Categoty exists";
        }
        jdbcTemplate.execute("insert into shop.category values(null,'"+name+"')");
        return "Category created";
    }
    //This method it's responsible with deleting a  Category from the database
    //First we check if the id it's in use and if it is we delete it.
    // If not we return a text that indicates that the object does not exist.
    public static String deleteCategoryById(JdbcTemplate jdbcTemplate, String id){
        Category category=CategoryUtility.getCategoryById(jdbcTemplate,id);
        if(category==null){
            return "Categoty does not exist";
        }
        jdbcTemplate.execute("delete from shop.category where id="+id);
        return "Category deleted";
    }

    //This method it's responsible with updating the name of a  Category from the database
    //First we check if the id it's in use and if it is we update it.
    // If not we return a text that indicates that the object does not exist.
    public static String changeCategoryName(JdbcTemplate jdbcTemplate,String id, String name){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,id);
        if(category==null){
            return "Categoty does not exist";
        }
        jdbcTemplate.execute("update shop.category set name="+name+" where id="+id+"");
        return "Category updated";
    }
}
