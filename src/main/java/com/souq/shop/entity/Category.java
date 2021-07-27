package com.souq.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private String name;
    private String description;
    private int ordering;
    private boolean visible;
    private boolean allowComment;
    private boolean allowAds;
}
