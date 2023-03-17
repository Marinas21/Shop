package com.Andrei.ShopWebService.Cart;

import com.Andrei.ShopWebService.User.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//This class represents all the communications with the database on a specific cart
public class CartData {
    //se verifica daca cart exista
    //cand cart ul se sterge se sterg si produsele din categoriile respective

    //This methode send a request to create a new cart for a specific user
    public static String createNewCart(JdbcTemplate jdbcTemplate, String userId){
        jdbcTemplate.execute("insert into shop.cart values(null,"+userId+")");
        return "Cart created";
    }
    //This methode send a request to delete a cart based on id
    public static String deleteCart(JdbcTemplate jdbcTemplate, String id){
        jdbcTemplate.execute("delete from shop.cart where id="+id+"");
        return "Cart deleted";
    }

    //This methode send a request to get a cart based on id
    public static Cart getCartById(JdbcTemplate jdbcTemplate, String id){
        List<Cart> list=jdbcTemplate.query("select * from shop.cart where id="+id+"",(rs, rowNum) ->
                new Cart(
                        rs.getInt("id"),
                        rs.getInt("userId")
                )
        );
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    //This methode send a request to get a cart based on user id
    public static Cart getCartByUserId(JdbcTemplate jdbcTemplate, String userId){
        List<Cart> list=jdbcTemplate.query("select * from shop.cart where userId="+userId+"",(rs, rowNum) ->
                new Cart(
                        rs.getInt("id"),
                        rs.getInt("userId")
                )
        );
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }
}
