package com.bsuir.trtpo.backend.service;

import com.bsuir.trtpo.backend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findProducts(String query, String sort, String order);
    List<Product> findProducts(String query, List<Product> validProducts);
    Product getProductById(Integer id);
    List<Product> findAllProducts();
    List<Product> findProductsByName(String name);
    List<Product> getLastViewed(List<Integer> ids);
}
