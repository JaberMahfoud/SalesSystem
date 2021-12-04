/**
 * 
 */
package com.salesSystem.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSystem.mvc.model.Log;

/**
 * @author Jaber
 *
 */
public interface LogRepository extends JpaRepository<Log, Integer>{
	boolean existsByid(Integer id);
}
