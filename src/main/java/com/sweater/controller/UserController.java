package com.sweater.controller;

import com.sweater.entities.User;
import com.sweater.service.UserService;
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

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
