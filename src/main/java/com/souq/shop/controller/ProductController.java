package com.souq.shop.controller;

import com.souq.shop.entity.Product;
import com.souq.shop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Product>> allProducts(){
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.FOUND);
    }
    @DeleteMapping("{/id}")
    public HttpStatus deleteProduct(@PathVariable UUID id){
        productRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
