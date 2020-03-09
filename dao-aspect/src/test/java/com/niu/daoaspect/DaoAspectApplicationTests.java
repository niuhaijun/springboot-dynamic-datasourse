package com.niu.daoaspect;

import com.niu.common.model.Product;
import com.niu.daoaspect.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaoAspectApplicationTests {

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


	@Test
	public void selectAll() {

		service.getAllProduct();
	}

}
