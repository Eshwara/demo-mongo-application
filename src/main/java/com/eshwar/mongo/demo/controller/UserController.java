package com.eshwar.mongo.demo.controller;

import com.eshwar.mongo.demo.model.User;
import com.eshwar.mongo.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){
        log.info("request received in post : "+ user);
        return userService.createUser(user);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody  User user){
       log.info("request received in put : "+ user);
       return userService.updateUser(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> geteUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id") String userId){
       return userService.getUser(userId);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable("id") String userId){
        return userService.deleteUser(userId);
    }


}
