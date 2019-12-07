package com.bsuir.trtpo.backend.service.serviceImpl;

import com.bsuir.trtpo.backend.entity.AuthToken;
import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.security.JwtUtil;
import com.bsuir.trtpo.backend.security.UserTokenModel;
import com.bsuir.trtpo.backend.service.AuthService;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Autowired
    public AuthServiceImpl(UserDetailsService userDetailsService, AuthenticationManager authenticationManager,
                                     JwtUtil jwtUtil, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    public UserTokenModel login(User user) {
        try {
            Optional<User> temp = userService.getUserByUsername(user.getUsername());
            String token = getToken(user);
            return new UserTokenModel(temp.get(), new AuthToken(token));
        } catch (AuthenticationException ex){
            return null;
        }
    }

    @Override
    public UserTokenModel register(User user) {
        User temp = userService.saveUser(user);
        String token = getToken(user);
        return new UserTokenModel(temp, new AuthToken(token));
    }

    private String getToken(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()
        );

        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated())
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return jwtUtil.generateToken(authenticationToken);
    }
}
