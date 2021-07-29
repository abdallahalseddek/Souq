package com.souq.shop.controller;

import com.souq.shop.entity.CartItem;
import com.souq.shop.entity.Product;
import com.souq.shop.entity.User;
import com.souq.shop.repository.CartItemRepository;
import com.souq.shop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartItemController {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    @GetMapping
    public ResponseEntity<List<CartItem>> allCartItems(User user){
        List<CartItem> userCartItems = cartItemRepository.findByUser(user);
        return new ResponseEntity<>(userCartItems, HttpStatus.FOUND);
    }
    @PostMapping
    public HttpStatus addItemToCart(@RequestBody CartItem cartItem){
      Product product = productRepository.findById(cartItem.getId()).get();
        CartItem byUserAndProduct = cartItemRepository.findByUserAndProduct(cartItem.getUser(), cartItem.getProduct());
        if (byUserAndProduct != null){

            // TODO : add cart item logic to check availability of items at cart by quantity
        }
        cartItemRepository.save(byUserAndProduct);

        return  HttpStatus.CREATED;
    }
}
