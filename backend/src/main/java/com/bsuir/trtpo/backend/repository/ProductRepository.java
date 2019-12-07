package com.bsuir.trtpo.backend.repository;

import com.bsuir.trtpo.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Product findProductById(Integer id);
    List<Product> findAllByName(String name);
    List<Product> findAllByPriceIsNotNullAndQuantityIsGreaterThan(Integer amount);
}
