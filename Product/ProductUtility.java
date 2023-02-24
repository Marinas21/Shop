package com.Andrei.ShopWebService.Product;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductUtility {

    //This method return a list of all the products from the database
    public static List<Product> getAllProducts(JdbcTemplate jdbcTemplate){
        return jdbcTemplate.query("select * from shop.product",(rs, rowNum) ->
                new Product(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("categoryId"),
                            rs.getDouble("price"))
                );
    }

    //this methode send a request to the database to return an object based on id
    //If we don't find one we return a null object
    public static Product  getProduct(JdbcTemplate jdbcTemplate, String id){
        List<Product> list =jdbcTemplate.query("select * from shop.product where id='"+id+"'",(rs, rowNum) ->
                new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("categoryId"),
                        rs.getDouble("price"))
        );
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    //This method return a list of all the products from the database that have a specific category
    public static List<Product> getAllProductsByCategory(JdbcTemplate jdbcTemplate , String categoryId){
        return jdbcTemplate.query("select * from shop.product where categoryId="+categoryId+"",(rs, rowNum) ->
                new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("categoryId"),
                        rs.getDouble("price"))
        );
    }
}
