package com.agh.product_catalouge.entity;

import com.agh.product_catalouge.model.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private long price;

    private long discount;

    private Category category;

    public Product() {
    }


    public Product(String description, long price, String name, long discount, Category category) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.discount = discount;
        this.category = category;
    }

   public Product(List<Product> products){

    }

    public long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
