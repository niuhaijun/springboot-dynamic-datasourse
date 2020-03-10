package com.niu.hikari.service;

import com.niu.common.mapper.ProductMapper;
import com.niu.common.model.Product;
import com.niu.hikari.config.TargetDataSource;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	private ProductMapper productDao;

	public ProductService(ProductMapper productDao) {

		this.productDao = productDao;
	}

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
	 *
	 * 切换数据源失败的原因为事务切面的order最低，
	 * 根据AOP的运行顺序，先进入事务AOP
	 * 这就导致切换数据源AOP尚未执行，无法切换数据源，
	 * 最终的表现就是
	 *  有事务的情况下切换数据源不生效
	 */
	@Transactional(rollbackFor = Exception.class)
	@TargetDataSource("slaveBeta")
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
	@TargetDataSource("slaveBeta")
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
	public List<Product> getAllProduct() {

		return productDao.getAllProduct();
	}
}
