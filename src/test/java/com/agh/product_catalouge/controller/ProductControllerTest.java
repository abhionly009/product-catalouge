package com.agh.product_catalouge.controller;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.model.Category;
import com.agh.product_catalouge.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockitoBean
     ProductService productService;

    @Autowired
    ObjectMapper objectMapper;

//    ProductControllerTest(ProductService productService) {
//        this.productService = productService;
//    }


    @Test
    void createProduct() throws Exception {

        Product product = new Product("abc",123L,"shoes",12L, Category.FASHION);

        when(productService.addProduct(any(Product.class)))
                .thenReturn(product);


        mockMvc.perform(post("/api/product/add").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(123L))
                .andExpect(jsonPath("$.name").value("shoes"))
                .andReturn();
    }

    @Test
    void getAllProduct() throws Exception{

        List<Product> products = new ArrayList<>();
        Product product = new Product("abc",123L,"shoes",12L, Category.FASHION);
        products.add(product);

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/product/getAll")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(products)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();
    }

    @Test
    void addProducts() throws Exception {
        List<Product> products = new ArrayList<>();

        Product product = new Product("xyz",145,"TV",8L, Category.ELECTRONICS);
        Product product2 = new Product("abc",123L,"shoes",12L, Category.FASHION);

        products.add(product2);
        products.add(product);

        when(productService.addProductInBulk(anyList())).thenReturn(products);

        mockMvc.perform(post("/api/product/addProducts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(products)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andReturn();

    }
}