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

import com.salesSystem.mvc.model.Product;
import com.salesSystem.mvc.service.ProductService;
/**
 * @author Jaber
 *
 */
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/ProductAPI")
public class ProductController {
	/*
	 * 
	 */
    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @CrossOrigin(origins = "*") 
	@PostMapping("/AddProduct")
	public  ResponseEntity<Product> AddProduct(@RequestBody Product product) {
		try {
			productService.insert(product);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Product>(product,HttpStatus.BAD_REQUEST);

		}
	}
    @CrossOrigin(origins = "*") 
	@PostMapping("/EditProduct")
	public  ResponseEntity<Product> EditProduct(@RequestBody Product product) {
		try {
			productService.update(product);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Product>(product,HttpStatus.BAD_REQUEST);

		}
	}
	@CrossOrigin(origins = "*") 
	@GetMapping("/GetProducts")
	public List<Product> GetProducts() {
		List<Product> Products =  new ArrayList<Product>();
		try {
			Products= productService.getProducts();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
		}
		return Products;
	}
	

}
