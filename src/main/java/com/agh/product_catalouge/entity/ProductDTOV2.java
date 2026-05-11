package com.agh.product_catalouge.entity;

import com.agh.product_catalouge.model.Category;

import java.math.BigDecimal;

public class ProductDTOV2 {



        private String productName;

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
