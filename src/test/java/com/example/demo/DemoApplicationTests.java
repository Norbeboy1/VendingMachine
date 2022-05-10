package com.example.demo;

import com.example.demo.converter.DepositConverter;
import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.BuyDto;
import com.example.demo.dto.DepositDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.PurchaseDto;
import com.example.demo.model.Deposit;
import com.example.demo.model.MyUser;
import com.example.demo.model.Product;
import com.example.demo.repository.MyUserRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.impl.BuyServiceImpl;
import com.example.demo.service.impl.DepositServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.remote.JMXPrincipal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Principal;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class DemoApplicationTests {
	private DepositServiceImpl depositService;
	private BuyServiceImpl buyService;
	private ProductServiceImpl productService;
	
	@Mock private DepositConverter depositConverter;
	@Mock private MyUserRepository myUserRepository;
	@Mock private ProductRepository productRepository;
	@Mock private ProductConverter productConverter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void deposit() {
		depositService = new DepositServiceImpl(myUserRepository, depositConverter);

		Deposit deposit = new Deposit();
		deposit.setTotalCoins(5);
		MyUser myUser = new MyUser();
		myUser.setUsername("a");
		myUser.setDeposit(deposit);
		DepositDto depositDto = new DepositDto();
		Long id = 1L;
		Principal principal = () -> "a";
		
		when(depositConverter.to(depositDto)).thenReturn(deposit);
		when(myUserRepository.findByUsername(principal.getName())).thenReturn(Optional.of(myUser));

		depositService.addDeposit(principal, depositDto);

		verify(myUserRepository).save(any(MyUser.class));
	}

	@Test
	void buy(){
		buyService = new BuyServiceImpl(productRepository, myUserRepository, productConverter);

		Product product = new Product();
		product.setCost(5);
		product.setProductName("a");
		product.setAmountAvailable(2);
		MyUser myUser = new MyUser();
		Deposit deposit = new Deposit();
		deposit.setTotalCoins(10);
		myUser.setDeposit(deposit);
		Long id = 1L;
		BuyDto buyDto = new BuyDto();
		buyDto.setProductId(id);
		buyDto.setAmountOfProducts(1);
		Principal principal = () -> "a";

		when(productRepository.findById(id)).thenReturn(Optional.of(product));
		when(myUserRepository.findByUsername(principal.getName())).thenReturn(Optional.of(myUser));

		PurchaseDto purchaseDto = buyService.buy(buyDto, principal);

		assertEquals(purchaseDto.getTotalCost(), product.getCost()*buyDto.getAmountOfProducts());
	}

	@Test
	void getProductById(){
		productService = new ProductServiceImpl(productConverter, productRepository);

		Product product = new Product();
		product.setProductName("a");
		ProductDto productDto = new ProductDto();
		productDto.setProductName("a");
		Long id = 1L;

		when(productRepository.findById(id)).thenReturn(Optional.of(product));
		when(productConverter.from(product)).thenReturn(productDto);

		ProductDto productDto1 = productService.getProductById(id);

		assertEquals(productDto1.getProductName(), productDto.getProductName());
	}
}
