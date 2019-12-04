package com.bsuir.trtpo.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Product product;

    @ManyToMany
    private User user;

    @Column(name = "cart_quantity")
    private Integer quantity;

    public Cart(User user, Product product, Integer cartQuantity) {
        this.user = user;
        this.product = product;
        this.quantity = cartQuantity;
    }

}
