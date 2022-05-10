package com.example.demo.converter;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class ProductConverter {

    public ProductDto from(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setProductName(product.getProductName());
        productDto.setCost(product.getCost());
        productDto.setAmountAvailable(product.getAmountAvailable());
        productDto.setSellerName(product.getSellerName());

        return productDto;
    }

    public Product to(ProductDto productDto, Principal principal){
        Product product = new Product();

        product.setProductName(productDto.getProductName());
        product.setCost(productDto.getCost());
        product.setAmountAvailable(productDto.getAmountAvailable());
        product.setSellerName(principal.getName());

        return product;
    }
}
