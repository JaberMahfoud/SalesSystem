/**
 * 
 */
package com.salesSystem.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSystem.mvc.model.Product;

/**
 * @author Jaber
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
	boolean existsByid(Integer id);
}
