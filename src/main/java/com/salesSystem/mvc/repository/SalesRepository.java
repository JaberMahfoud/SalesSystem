/**
 * 
 */
package com.salesSystem.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSystem.mvc.model.Sales;

/**
 * @author Jaber
 *
 */
public interface SalesRepository extends JpaRepository<Sales, Integer>{
	 boolean existsByid(Integer id);
}
