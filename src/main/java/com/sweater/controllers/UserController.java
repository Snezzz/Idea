package com.sweater.controllers;

import com.sweater.entities.User;
import com.sweater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
