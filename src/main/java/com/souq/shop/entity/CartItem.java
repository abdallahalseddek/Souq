package com.souq.shop.entity;

import com.souq.shop.entity.Product;
import com.souq.shop.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private int quantity;
}
