package com.niu.daoaspect.service;

import com.niu.common.mapper.ProductMapper;
import com.niu.common.model.Product;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	@Resource
	private ProductMapper productDao;

	/**
	 * Get product by id
	 * If not found product will throw ServiceException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Product select(long productId) {

		Product product = productDao.select(productId);
		if (product == null) {
			throw new RuntimeException("Product:" + productId + " not found");
		}
		return product;
	}

	/**
	 * Update product by id
	 * If update failed will throw ServiceException
	 */
	public Product update(long productId, Product newProduct) {

		if (productDao.update(newProduct) <= 0) {
			throw new RuntimeException("Update product:" + productId + "failed");
		}
		return newProduct;
	}

	/**
	 * Add product to DB
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean add(Product newProduct) {

		Integer num = productDao.insert(newProduct);
		if (num <= 0) {
			throw new RuntimeException("Add product failed");
		}

		return true;
	}

	/**
	 * Delete product from DB
	 */
	public boolean delete(long productId) {

		Integer num = productDao.delete(productId);
		if (num <= 0) {
			throw new RuntimeException("Delete product:" + productId + "failed");
		}
		return true;
	}

	/**
	 * Get all product
	 */
//	@Transactional
	public List<Product> getAllProduct() {

		return productDao.getAllProduct();
	}
}
