package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController @AllArgsConstructor @RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto, Principal principal){
        productService.addProduct(productDto, principal);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto, Principal principal) {
        productService.updateProduct(id, productDto, principal);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
