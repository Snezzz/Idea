package com.sweater.controllers;

import com.sweater.components.UserComponent;
import com.sweater.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserComponent userComponent;

    @GetMapping("/users")
    //name - название параметра (для обращения из шаблона)
    public String show(Map<String,Object> model) {
        userComponent.saveOrUpdate(new User(1,"Ann","123"));
        userComponent.saveOrUpdate(new User(2,"Bill","321"));
        userComponent.saveOrUpdate(new User(3,"John","213"));
        Iterable<User> users = userComponent.getAllUsers();
        model.put("users",users);
        return "test";
    }
}
