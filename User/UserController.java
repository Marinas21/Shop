package com.Andrei.ShopWebService.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//This class is responsible for all the listeners which involves users
@Controller
public class UserController {

    //On this line we create a new object that will help us in the future with the database connection
    private final JdbcTemplate jdbcTemplate;
    //Here we instantiate a constructor which take a jdbctemplate as parameter and give it to the object
    //we created early
    @Autowired
    public UserController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //This method take input from the URL and send two requests to the database
    //The first we'll search for an account with this mail address and if it exits we'll notify
    //If the mail it's not in the database we'll send a second request to create the user
    //then it will return the new user with the id
    @GetMapping("/newUser")
    @ResponseBody
    public String newUser(@RequestParam(name="name")String name,
                          @RequestParam(name="email")String mail,
                          @RequestParam(name="password")String password) throws SQLException {
        return UserData.addNewUser(jdbcTemplate,name,mail,password);
    }

    //This method will return all the users with their info from the database
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){
        return UserUtility.getAllUsers(jdbcTemplate);
    }

    //Here we'll search for a user that have this specific mail and password and if this user
    //does not exist we'll return null, otherwise we'll return the user
    @GetMapping("/login")
    @ResponseBody
    public User login(@RequestParam(name="email")String mail,
                      @RequestParam(name="password")String password){
       return UserData.logIn(jdbcTemplate,mail,password);
    }

    //This method will send a request to delete a user with this specific id
    @GetMapping("/delete")
    @ResponseBody
    public String deleteUser(@RequestParam(name="id") String id){
        return UserData.deleteUser(jdbcTemplate,id);
    }

    //this method will send an update request to change the password from a user based on that id
    @GetMapping("/changepassword")
    @ResponseBody
    public String changePassword(@RequestParam(name="id")String id,@RequestParam(name="password")String password){
        return UserData.changePasswprd(jdbcTemplate,id,password);
    }


}
