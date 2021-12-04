/**
 * 
 */
package com.salesSystem.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSystem.mvc.model.Client;

/**
 * @author Jaber
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{
	boolean existsByid(Integer id);
}
