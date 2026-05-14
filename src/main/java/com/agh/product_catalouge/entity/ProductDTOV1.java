package com.agh.product_catalouge.entity;

import com.agh.product_catalouge.model.Category;
import jakarta.validation.constraints.*;

public class ProductDTOV1 {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 40)
    private String name;

    @NotNull(message = "Price must be there")
    @Positive(message = "Price of product should be positive")
    private Long price;

    private Category category;

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    @Positive(message = "Discount should be positive")
    private long discount;

    @NotBlank(message = "Brand must be there")
    private String brand;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank(message = "Description of product must be available")
    @Size(min = 10, max = 500)
    private String description;

    public ProductDTOV1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
