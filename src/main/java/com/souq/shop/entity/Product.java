package com.souq.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
