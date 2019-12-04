package com.bsuir.trtpo.backend.service;

import com.bsuir.trtpo.backend.dto.CartDto;
import com.bsuir.trtpo.backend.dto.CartItemDto;
import com.bsuir.trtpo.backend.dto.OrderDto;

public interface CartService {
    void addToCart(CartItemDto cartItem);
    CartDto getCart(Integer userId);
    void deleteCartItem(Integer userId, Integer productId);
    void placeOrder(OrderDto orderDto);
}
