/**
 *
 */
package com.salesSystem.mvc.service;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesSystem.mvc.model.Log;
import com.salesSystem.mvc.repository.LogRepository;

@Service
public class LogService {
	private final LogRepository repository;
	private static Logger LOGGER = LoggerFactory.getLogger(LogService.class);

	public LogService(LogRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public void insert(String className,String method,String arguments,String response,Long executionTime) {
		try {			
			Log log=new Log(className,method,arguments,response,executionTime,LocalDateTime.now());
			repository.save(log);
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
	}
	
	
}
