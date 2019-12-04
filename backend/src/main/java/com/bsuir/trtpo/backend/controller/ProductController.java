package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.service.ProductService;
import com.bsuir.trtpo.backend.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public List<Product> getProducts(@RequestParam(name = "query", required = false) String query,
                                    @RequestParam(name = "sort", required = false) String sort,
                                    @RequestParam(name = "order", required = false) String order) {

        return productService.findProducts(query, sort, order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable(name = "id") Integer id) {
        return productService.getProductById(id);
    }
}
