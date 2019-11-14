package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.service.ProductService;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Product added");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getProductByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }
}
