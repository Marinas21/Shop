package com.Andrei.ShopWebService.User;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

//This class represents all the communications with the database on a list of users
public class UserUtility {

    //This method send a request to get all the users from the database and return a list of users
    public static List<User> getAllUsers(JdbcTemplate jdbcTemplate){
        List<User> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.users",(rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("password")
                )
        );
        return list;
    }
    //This method check if there are users that have a specific mail
    public static Boolean checkIfUserExistByMail(JdbcTemplate jdbcTemplate, String mail){
        List<User> list=new ArrayList<>();
        list=jdbcTemplate.query("select * from shop.users where email='"+mail+"'",(rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("password")
                )
        );
        if (list.size()!=0){
            return false;
        }
        else{
            return true;
        }
    }

    //this methode send a request to the databse to see if there is a user with a specific mail and password
    public static User checkIfUserExistByMailAndPassword(JdbcTemplate jdbcTemplate, String mail, String password){
        List<User> user= jdbcTemplate.query("select * from shop.users where email= '"+mail+"' and password= '"+password+"'",(rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("password")
                )
        );
        if(user.size()==1){
            return user.get(0);
        }
        else{
            return null;
        }
    }
}
