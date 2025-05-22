package org.sebprojects.expensetracker_user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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




}
