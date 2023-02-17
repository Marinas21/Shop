package com.Andrei.ShopWebService.Product;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProductUtility {

    //This method return all the products from the database
    public static List<Product> getAllProducts(JdbcTemplate jdbcTemplate){
        return jdbcTemplate.query("select * from shop.product",(rs, rowNum) ->
                new Product(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("categoryId"),
                            rs.getDouble("price"))
                );
    }

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

}
