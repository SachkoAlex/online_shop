package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User added");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getUserByEmail(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
