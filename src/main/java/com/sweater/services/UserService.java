package com.sweater.services;

import com.sweater.entities.User;
import com.sweater.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //all users
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    //add or update
    public void addUser(User user){
        userRepository.save(user);
    }
    //delete object
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    //delete by id of user
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }
}
