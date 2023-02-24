package com.Andrei.ShopWebService.Category;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CategoryUtility {

    //this methode returns a list of all the categories
    public static List<Category> getAllCategorys(JdbcTemplate jdbcTemplate){
        List<Category> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.users",(rs, rowNum) ->
                new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );
        return list;
    }

    //this methode returns a category object based on id
    public static Category getCategoryById(JdbcTemplate jdbcTemplate, String id){
        List<Category> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.users where email='"+id+"'",(rs, rowNum) ->
                new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );
        if (list.size()!=0){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    //this methode returns a category object based on name
    public static Category getCategoryByName(JdbcTemplate jdbcTemplate, String name){
        List<Category> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.users where email='"+name+"'",(rs, rowNum) ->
                new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );
        if (list.size()!=0){
            return null;
        }
        else{
            return list.get(0);
        }
    }
}
