package org.sebprojects.expensetracker_user.controllers;

import org.sebprojects.expensetracker.dtos.UserInfoDto;
import org.sebprojects.expensetracker_user.entities.UserDetails;
import org.sebprojects.expensetracker_user.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    // Add your endpoints and methods here
    // For example:
    // @GetMapping("/users")
    // public List<UserInfoDto> getAllUsers() {
    //     return userService.getAllUsers();
    // }

    // Add more methods as needed for your application
    // Example method to get user by ID
    // @GetMapping("/users/{id}")
    // public UserInfoDto getUserById(@PathVariable Long id) {


    //     return userService.getUserById(id);
    // }

    // just a hello test api
     @GetMapping("/hello")
     public String helloWorld() {
         return "Hello, World!";
     }

     // To-do: Add more endpoints and methods as needed for your application
        // Example method to get user by ID
    // @GetMapping("/users/{id}")

    @GetMapping("/users")
    public List<UserInfoDto> getAllUsers() {
        return userDetailsService.getAllUsers();
    }


}
