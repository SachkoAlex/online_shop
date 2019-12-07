package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.dto.CartDto;
import com.bsuir.trtpo.backend.dto.CartItemDto;
import com.bsuir.trtpo.backend.dto.OrderDto;
import com.bsuir.trtpo.backend.entity.Cart;
import com.bsuir.trtpo.backend.service.CartService;
import com.bsuir.trtpo.backend.service.serviceImpl.CartServiceImpl;
import com.bsuir.trtpo.backend.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addToCart(@RequestBody CartItemDto cartItemDto) {
        cartService.addToCart(cartItemDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public CartDto getCart(@RequestParam(name = "userId") Integer id) {
        return cartService.getCart(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteFromCart(@RequestParam(name = "userId") Integer userid,
                               @RequestParam(name = "productId") Integer productid) {
        cartService.deleteCartItem(userid, productid);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void placeOrder(@RequestBody OrderDto orderDto)  {
        cartService.placeOrder(orderDto);
    }
}
