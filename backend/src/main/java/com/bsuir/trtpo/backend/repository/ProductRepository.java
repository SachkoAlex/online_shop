package com.bsuir.trtpo.backend.repository;

import com.bsuir.trtpo.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product>  findProductByName(String name);
    Product findProductById(Integer id);
    List<Product> findAllByPriceIsNotNullAndAmountIsGreaterThan(Integer amount);
}
