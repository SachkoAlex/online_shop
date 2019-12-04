package com.bsuir.trtpo.backend.security;

import com.bsuir.trtpo.backend.entity.AuthToken;
import com.bsuir.trtpo.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTokenModel {
    User user;
    AuthToken token;
}
