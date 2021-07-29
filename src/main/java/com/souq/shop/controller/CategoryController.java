package com.souq.shop.controller;

import com.souq.shop.entity.Category;
import com.souq.shop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category savedCategory = categoryRepository.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Category>> allCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.FOUND);
    }
    @DeleteMapping
    public HttpStatus deleteCategory(UUID id){
        categoryRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
