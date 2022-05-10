package com.example.demo.service.impl;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductConverter productConverter, ProductRepository productRepository) {
        this.productConverter = productConverter;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        ProductDto productDto;
        for (Product product : products){
            productDto = productConverter.from(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productConverter.from(productRepository.findById(id).get());
    }

    @Override
    public void addProduct(ProductDto productDto, Principal principal) {
        Product product = productRepository.findByProductName(productDto.getProductName());
        if(product==null) {
            product = productConverter.to(productDto, principal);
            productRepository.save(product);
        }
    }

    @Override
    public void updateProduct(Long id, ProductDto productDto, Principal principal) {
        Product product = productRepository.findById(id).get();
        product.setProductName(productDto.getProductName());
        product.setAmountAvailable(productDto.getAmountAvailable());
        product.setCost(productDto.getCost());
        product.setSellerName(principal.getName());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

