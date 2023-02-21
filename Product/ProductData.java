package com.Andrei.ShopWebService.Product;

import org.springframework.jdbc.core.JdbcTemplate;

//This class it;s responsible for CRUD on a single product
public class ProductData {

    //We send a request and return a user
    public static Product getProductById(JdbcTemplate jdbcTemplate,String id){
        return ProductUtility.getProduct(jdbcTemplate,id);
    }

    //We check if the user exist and after that send a request to delete it
    public static String deleteProduct(JdbcTemplate jdbcTemplate,String id){
        if(checkIfProductExists(jdbcTemplate,id)){
            return "Product does not exist";
        }
        jdbcTemplate.execute("delete * from shop.product where id='"+id+"'");
        return "Product deleted";
    }

    //We check if the user exist and after that send a request to delete it's name
    public static String changeProductName(JdbcTemplate jdbcTemplate,String id,String newName){
        if(checkIfProductExists(jdbcTemplate,id)){
            return "Product does not exist";
        }
        jdbcTemplate.execute("update shop.product set name='"+newName+"' where id='"+id+"'");
        return "Product changed";
    }

    //We check if the user exist and after that send a request to delete it's category
    public static String changeProductCategory(JdbcTemplate jdbcTemplate,String id,String categoryId){
        if(checkIfProductExists(jdbcTemplate,id)){
            return "Product does not exist";
        }
        jdbcTemplate.execute("update shop.product set categoryId="+categoryId+" where id='"+id+"'");
        return "Product changed";
    }

    //We check if the user exist and after that send a request to delete it's price
    public static String changeProductPrice(JdbcTemplate jdbcTemplate,String id,String price){
        if(checkIfProductExists(jdbcTemplate,id)){
            return "Product does not exist";
        }
        jdbcTemplate.execute("update shop.product set price="+price+" where id='"+id+"'");
        return "Product changed";
    }
    public static String createProduct(JdbcTemplate jdbcTemplate, String name, String categoryId, String price){
        jdbcTemplate.execute("insert into shop.product values(null,'"+name+"',"+categoryId+","+price+",)");
        return "Product created";
    }
    //This method send a request to select the user with a specific id and to see if it exists
    public static boolean checkIfProductExists(JdbcTemplate jdbcTemplate,String id){
        Product product=ProductUtility.getProduct(jdbcTemplate,id);
        if(product==null){
            return true;
        }
        return false;
    }
}
