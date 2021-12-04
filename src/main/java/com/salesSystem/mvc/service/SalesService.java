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

import com.salesSystem.mvc.model.Sales;
import com.salesSystem.mvc.repository.SalesRepository;

@Service
public class SalesService {
	private final SalesRepository repository;
	private static Logger LOGGER = LoggerFactory.getLogger(SalesService.class);

	public SalesService(SalesRepository repository) {
		this.repository = repository;
	}
	public List<Sales> getSales() {
		List<Sales> sales = new ArrayList<Sales>();
		try {
				sales = repository.findAll();
			
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
		return sales;
	}
	@Transactional
	public void insert(Sales sales) {
		try {
			sales.setCreationDate(LocalDateTime.now());
			repository.save(sales);
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
	}
	@Transactional
	public void update(Sales sales) {
		try {
			Integer salesId=sales.getID();
			if(isExist(salesId)) {
				Sales oldSales=repository.getById(salesId);
				oldSales.setSeller(null);
				oldSales.setTotal(salesId);			
				repository.save(oldSales);
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
