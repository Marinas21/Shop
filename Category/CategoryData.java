package com.Andrei.ShopWebService.Category;

import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryData {

    public static String createCategory(JdbcTemplate jdbcTemplate, String name){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,name);
        if(category!=null){
            return "Categoty exists";
        }
        jdbcTemplate.execute("insert into shop.category values(null,'"+name+"')");
        return "Category created";
    }

    public static String deleteCategoryById(JdbcTemplate jdbcTemplate, String id){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,id);
        if(category==null){
            return "Categoty does not exist";
        }
        jdbcTemplate.execute("delete from shop.category where id="+id);
        return "Category deleted";
    }

    public static String changeCategoryName(JdbcTemplate jdbcTemplate,String id, String name){
        Category category=CategoryUtility.getCategoryByName(jdbcTemplate,id);
        if(category==null){
            return "Categoty does not exist";
        }
        jdbcTemplate.execute("update shop.category set name="+name+" where id="+id+"");
        return "Category updated";
    }
}
