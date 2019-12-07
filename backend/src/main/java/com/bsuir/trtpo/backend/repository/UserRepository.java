package com.bsuir.trtpo.backend.repository;

import com.bsuir.trtpo.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserById(Integer id);
}
