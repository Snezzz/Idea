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
    @GetMapping("/user/{userName}")
    public User getUser(@PathVariable String userName){
        return userService.getUserByName(userName);
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
    public void deleteUserByName(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
