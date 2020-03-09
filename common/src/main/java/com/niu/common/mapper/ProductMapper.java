package com.niu.common.mapper;

import com.niu.common.model.Product;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ProductMapper {

	Product select(@Param("id") long id);

	Integer update(Product product);

	Integer insert(Product product);

	Integer delete(long productId);

	List<Product> getAllProduct();
}
