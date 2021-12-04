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

import com.salesSystem.mvc.model.Client;
import com.salesSystem.mvc.service.ClientService;
/**
 * @author Jaber
 *
 */
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/ClientAPI")
public class ClientController {
	/*
	 * 
	 */
    private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;
	@PostMapping("/AddClient")
	public  ResponseEntity<Client> AddClient(@RequestBody Client client) {
		try {
			clientService.insert(client);
			return new ResponseEntity<Client>(client,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Client>(client,HttpStatus.BAD_REQUEST);

		}
	}
	@PostMapping("/EditClient")
	public  ResponseEntity<Client> EditClient(@RequestBody Client client) {
		try {
			clientService.update(client);
			return new ResponseEntity<Client>(client,HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
			return new ResponseEntity<Client>(client,HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/GetClients")
	public List<Client> GetClients() {
		List<Client> Clients =  new ArrayList<Client>();
		try {
			Clients= clientService.getClients();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
		}
		return Clients;
	}
	public static Client getClientById(Integer id) {
		Client client = null;
		try {
			//client= clientService.getClientByID(id);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
            LOGGER.info("Run time error: " + e.getMessage());
		}
		return client;
	}
}
