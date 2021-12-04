/**
 *
 */
package com.salesSystem.mvc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesSystem.mvc.model.Product;
import com.salesSystem.mvc.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;
	private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	public List<Product> getProducts() {
		List<Product> Products = new ArrayList<Product>();
		try {
				Products = repository.findAll();			
			
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
		return Products;
	}
	@Transactional
	public void insert(Product product) {
		try {
			product.setCreationDate(LocalDateTime.now());
			repository.save(product);
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
	}
	@Transactional
	public void update(Product product) {
		try {
			Integer productId=product.getID();
			if(isExist(productId)) {
				Product oldProduct=repository.getById(productId);
				oldProduct.setCategory(product.getCategory());
				oldProduct.setName(product.getName());
				oldProduct.setDescription(product.getDescription());
				repository.save(oldProduct);
			}
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
	}
	public boolean isExist(Integer id) {
		try {
			return repository.existsByid(id);
		} catch (Exception e) {
			return false;
		}
	}
}
