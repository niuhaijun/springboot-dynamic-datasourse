package com.niu.hikari;

import com.niu.common.model.Product;
import com.niu.hikari.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class HikariApplicationTests {

	@Autowired
	private ProductService service;

	@Test
	public void getAllProduct() {
		service.getAllProduct();
	}

	@Test
	public void add() {

		Product newProduct = new Product();
		newProduct.setName("niu");
		newProduct.setPrice(101);

		service.add(newProduct);
	}

}
