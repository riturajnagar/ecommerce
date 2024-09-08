package com.onlineshopping.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
