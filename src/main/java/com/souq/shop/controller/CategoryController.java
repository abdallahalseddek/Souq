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
    // inject by constructor
    private final CategoryRepository categoryRepository;
    // category post request : send request at http body
    // response contains : the category i just added + httpStatus: 201
    // TODO : Admins only can add or delete categories
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category savedCategory = categoryRepository.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    // TODO : All users can show categories
    @GetMapping
    public ResponseEntity<List<Category>> allCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.FOUND);
    }
    // delete category by give me id of category stored in database
    // i don't have logic in my head for user give me id he doesn't know

    @DeleteMapping("{/id}")
    public HttpStatus deleteCategory(@PathVariable UUID id){
        categoryRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
