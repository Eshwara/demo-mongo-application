package com.eshwar.mongo.demo.service;

import com.eshwar.mongo.demo.model.User;
import com.eshwar.mongo.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){

        return userRepository.save(user);
    }

    public User updateUser(User user){

       return  userRepository.save(user);
    }

    public User getUser(String userId){

       Optional<User> optUser =  userRepository.findById(userId);

       return optUser.orElse(new User());
    }

    public String deleteUser(String userId){

        userRepository.deleteById(userId);

        return "success";
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }
}
