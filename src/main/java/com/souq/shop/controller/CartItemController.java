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
    // inject objects of classes
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    // Http Get Request to api. it returns List Item & 302 Response
    // it'll return all products that user added to cart
    // TODO : user should can change quantity of any product here or when adding to cart

    @GetMapping
    public ResponseEntity<List<CartItem>> allCartItems(User user){
        List<CartItem> userCartItems = cartItemRepository.findByUser(user);
        return new ResponseEntity<>(userCartItems, HttpStatus.FOUND);
    }

    //Http post request . it returns Http response : 201
    // user add product to cart(saved to database)
    // TODO : No database for cart. check another way to store cart items like cookies or sessions or something like that
    @PostMapping("/add")
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
