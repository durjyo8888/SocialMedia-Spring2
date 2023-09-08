package com.example.SocialMediaSystem.Controller;

import com.example.SocialMediaSystem.Model.User;
import com.example.SocialMediaSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity("added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/max-number-of-notification")
    public ResponseEntity getMaxNoOfNotificationByUser(){
        int userId = userService.getMaxNoOfNotificationByUser();
        return new ResponseEntity(userId, HttpStatus.FOUND);
    }
}
