package com.souq.shop.repository;

import com.souq.shop.entity.CartItem;
import com.souq.shop.entity.Product;
import com.souq.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findByUser(User user);
    CartItem findByUserAndProduct(User user, Product product);
}
