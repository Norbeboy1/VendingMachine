package com.example.demo.service.impl;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.BuyDto;
import com.example.demo.dto.PurchaseDto;
import com.example.demo.model.Deposit;
import com.example.demo.model.MyUser;
import com.example.demo.model.Product;
import com.example.demo.repository.MyUserRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.BuyService;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class BuyServiceImpl implements BuyService {
    private final ProductRepository productRepository;
    private final MyUserRepository myUserRepository;
    private final ProductConverter productConverter;

    public BuyServiceImpl(ProductRepository productRepository, MyUserRepository myUserRepository,
                          ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.myUserRepository = myUserRepository;
        this.productConverter = productConverter;
    }

    @Override
    public PurchaseDto buy(BuyDto buyDto, Principal principal) {
        Product product = productRepository.findById(buyDto.getProductId()).get();
        MyUser myUser = myUserRepository.findByUsername(principal.getName()).get();
        Deposit deposit = myUser.getDeposit();
        PurchaseDto purchaseDto = new PurchaseDto();

        int totalCost = product.getCost() * buyDto.getAmountOfProducts();

        if(deposit.getTotalCoins() >= totalCost && buyDto.getAmountOfProducts() <= product.getAmountAvailable()) {
            deposit.setTotalCoins(deposit.getTotalCoins() - totalCost);
            product.setAmountAvailable(product.getAmountAvailable() - buyDto.getAmountOfProducts());
            myUser.setDeposit(deposit);

            purchaseDto.setTotalCost(totalCost);
            purchaseDto.setChange(deposit.getTotalCoins());
            purchaseDto.setProductDto(productConverter.from(product));

            productRepository.save(product);
            myUserRepository.save(myUser);
        }

        return purchaseDto;
    }
}
