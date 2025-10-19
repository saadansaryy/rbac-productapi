package com.saad.rbac_productapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category categoryId;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;
}
