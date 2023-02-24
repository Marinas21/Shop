package com.Andrei.ShopWebService.User;

import org.springframework.jdbc.core.JdbcTemplate;

//This class represents all the communications with the database on a specific user
public class UserData {

    //Here we check if user exit sending a request to the database and if we find
    //an existing user we return it and if not we return a null
    public static User logIn(JdbcTemplate jdbcTemplate, String mail, String password){
       return UserUtility.checkIfUserExistByMailAndPassword(jdbcTemplate,mail,password);
    }
    //Here we send a request to delete a user based on his id
    public static String deleteUser(JdbcTemplate jdbcTemplate, String id){
        jdbcTemplate.execute("delete from shop.users where id="+id+"");
        return "User Deleted";
    }
    //we update a user password .We condition this update based on the id
    public static String changePasswprd(JdbcTemplate jdbcTemplate, String id,String password){
        jdbcTemplate.update("update shop.users set password='"+password+"' where id="+id+"");
        return "Password Changed";
    }
    //Here it's the logic behind adding new users, first we check if the user exist and
    //after that if the mail it's not in the database we send a second request to create a new
    //user then we return a message
    public static String addNewUser(JdbcTemplate jdbcTemplate, String name, String mail, String password){
        String userName=name;
        String userMail=mail;
        String userPassword=password;
        if(UserUtility.checkIfUserExistByMail(jdbcTemplate,userMail)){
        jdbcTemplate.update("insert into shop.users values(null,'"+userName+"','"+userMail+"','"+userPassword+"')");
        return "User succsesfully created";}
        else{
            return "Mail in use";
        }
    }
}
