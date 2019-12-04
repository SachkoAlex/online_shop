package com.bsuir.trtpo.backend.dto;

import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDto {
    User user;
    List<Product> products;
    Integer totalPrice;

    public CartDto() {
        products = new ArrayList<>();
    }
}
