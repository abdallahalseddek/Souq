package com.souq.shop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,updatable = true)
    private String title;
    @Column(nullable = false)
    private String summary;
    @Column(nullable = false)
    private float price;
    private float discount;
    @Column(nullable = false)
    private int quantity;
    private LocalDateTime createdAt;

}
