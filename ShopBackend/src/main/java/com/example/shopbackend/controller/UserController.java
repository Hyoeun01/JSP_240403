package com.example.shopbackend.controller;

import com.example.shopbackend.model.User;
import com.example.shopbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "Hello World";
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/user/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username).orElseThrow();
    }

    @GetMapping("/allUser")
    public List<User> allUser(){
        return userService.userAll();
    }

    @PutMapping("/user")
    public void changeRole(@RequestBody User user) {
        userService.changeRole(user.getRole(),user.getUsername());

    }
}
