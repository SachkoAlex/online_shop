package com.bsuir.trtpo.backend.service;

import com.bsuir.trtpo.backend.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Integer id);
    Optional<User> getUserByUsername(String username);
    User saveUser(User user);
    void deleteUser(Integer id);
}
