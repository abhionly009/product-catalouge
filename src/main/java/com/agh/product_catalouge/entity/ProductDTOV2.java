package com.agh.product_catalouge.entity;

import com.agh.product_catalouge.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDTOV2 {


    @NotBlank(message = "Product name should be there")
    @Size(min = 3, max = 40)
    private String productName;

    @NotBlank(message = "Product description must be there")
    private String description;

    private long  price;

    private long discount;

    private Category category;


    public ProductDTOV2() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
