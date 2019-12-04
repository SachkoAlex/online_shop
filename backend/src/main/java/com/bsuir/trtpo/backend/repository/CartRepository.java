package com.bsuir.trtpo.backend.repository;

import com.bsuir.trtpo.backend.entity.Cart;
import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUser(User user);
    Integer deleteByProductAndUser(Product product, User user);
    Cart getByUserAndProduct(User user, Product product);
}
