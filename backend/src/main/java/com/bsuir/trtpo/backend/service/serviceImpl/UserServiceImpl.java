package com.bsuir.trtpo.backend.service.serviceImpl;

import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.entity.Wallet;
import com.bsuir.trtpo.backend.repository.UserRepository;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User saveUser(User user) {
        Optional<User> temp = userRepository.findUserByEmail(user.getEmail());
        if (user.getId() != null || !temp.isPresent()) {
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

}
