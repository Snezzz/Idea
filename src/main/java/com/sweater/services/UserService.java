package com.sweater.services;

import com.sweater.entities.User;
import com.sweater.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sweater.enums.UserRole.USER;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(USER);
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
    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
