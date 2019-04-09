package com.sweater.components;

import com.sweater.entities.User;
import com.sweater.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
    public void saveOrUpdate(User user){
        userRepository.save(user);
    }
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }
}
