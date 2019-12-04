package com.bsuir.trtpo.backend.service.serviceImpl;

import com.bsuir.trtpo.backend.dto.CartDto;
import com.bsuir.trtpo.backend.dto.CartItemDto;
import com.bsuir.trtpo.backend.dto.OrderDto;
import com.bsuir.trtpo.backend.entity.Cart;
import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.entity.User;
import com.bsuir.trtpo.backend.repository.CartRepository;
import com.bsuir.trtpo.backend.service.CartService;
import com.bsuir.trtpo.backend.service.ProductService;
import com.bsuir.trtpo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void addToCart(CartItemDto cartItem) {
        User user = userService.getUserById(cartItem.getUserId()).get();
        Product product= productService.getProductById(cartItem.getProductId());
        Cart cart =cartRepository.getByUserAndProduct(user,product);
        if(cart == null)
        {
            cartRepository.save(new Cart(user,product,cartItem.getQuantity()));
        }   else{
            cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
            cartRepository.save(cart);
        }

    }

    @Override
    public CartDto getCart(Integer userId) {
        CartDto cartDto = new CartDto();
        User user = userService.getUserById(userId).get();
        List<Cart> carts = cartRepository.findAllByUser(user);
        Integer totalPrice = 0;

        for (Cart cart : carts) {
            Product product = cart.getProduct();
            product.setQuantity(cart.getQuantity());
            cartDto.getProducts().add(product);
            totalPrice += cart.getProduct().getPrice() * cart.getQuantity();
        }
        cartDto.setTotalPrice(totalPrice);
        cartDto.setUser(user);
        return cartDto;
    }

    @Override
    @Transactional
    public void deleteCartItem(Integer userId, Integer productId) {
        User user = userService.getUserById(userId).get();
        Product product = productService.getProductById(productId);
        cartRepository.deleteByProductAndUser(product, user);
    }

    @Override
    @Transactional
    public void placeOrder(OrderDto orderDto) {
        for(Product product: orderDto.getCart().getProducts()) {
            cartRepository.deleteByProductAndUser(product, orderDto.getCart().getUser());
        }
    }
}
