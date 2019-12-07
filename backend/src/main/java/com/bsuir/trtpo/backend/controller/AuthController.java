package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.security.UserTokenModel;
import com.bsuir.trtpo.backend.service.AuthService;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserTokenModel login(@RequestBody User loginUser) {
        return authService.login(loginUser);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserTokenModel register(@RequestBody User registerUser) {
        return authService.register(registerUser);
    }
}
