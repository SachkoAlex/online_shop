package com.bsuir.trtpo.backend.service;

import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.security.UserTokenModel;

public interface AuthService {
    UserTokenModel login(User user);
    UserTokenModel register(User user);
}
