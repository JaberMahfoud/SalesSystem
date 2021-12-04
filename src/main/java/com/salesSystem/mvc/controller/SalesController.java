/**
 * 
 */
package com.salesSystem.mvc.controller;


import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salesSystem.mvc.model.Sales;
import com.salesSystem.mvc.service.SalesService;
/**
 * @author Jaber
 *
 */
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/SalesAPI")
public class SalesController {
	/*
	 * 
	 */
    private static Logger LOGGER = LoggerFactory.getLogger(SalesController.class);
    @Autowired
    private SalesService salesService;
	@PostMapping("/AddSales")
	public  ResponseEntity<Sales> AddSales(@RequestBody Sales sales) {
		try {
			//Client client=ClientController.getClientById(clientID);
			salesService.insert(sales);
			return new ResponseEntity<Sales>(sales,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Sales>(sales,HttpStatus.BAD_REQUEST);

		}
	}
	@PostMapping("/EditSales")
	public  ResponseEntity<Sales> EditSales(@RequestBody Sales sales) {
		try {
			salesService.update(sales);
			return new ResponseEntity<Sales>(sales,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Sales>(sales,HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/GetSaless")
	public List<Sales> GetSaless() {
		List<Sales> Saless =  new ArrayList<Sales>();
		try {
			Saless= salesService.getSales();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
		}
		return Saless;
	}
	

}
