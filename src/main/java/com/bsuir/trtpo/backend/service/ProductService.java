package com.bsuir.trtpo.backend.service;

import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }
}
