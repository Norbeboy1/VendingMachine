package com.example.demo.service;

import com.example.demo.dto.ProductDto;

import java.security.Principal;
import java.util.List;

public interface ProductService {

    /** returns all products from db */
    List<ProductDto> getProducts();

    /** returns a product from db */
    ProductDto getProductById(Long id);

    /** adds a product in db */
    void addProduct(ProductDto productDto, Principal principal);

    /** updates a product in db */
    void updateProduct(Long id, ProductDto productDto, Principal principal);

    /** deletes a product in db */
    void deleteProduct(Long id);
}
