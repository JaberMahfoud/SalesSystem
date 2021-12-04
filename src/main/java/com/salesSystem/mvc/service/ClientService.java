/**
 *
 */
package com.salesSystem.mvc.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesSystem.mvc.model.Client;
import com.salesSystem.mvc.repository.ClientRepository;

@Service
public class ClientService {
	private final ClientRepository repository;
	private static Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	public List<Client> getClients() {
		List<Client> Clients = new ArrayList<Client>();
		try {
			Clients = repository.findAll();

		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
		return Clients;
	}
	@Transactional
	public void insert(Client client) {
		try {
			repository.save(client);
		} catch (Exception e) {
			LOGGER.info("Error : " + e.getMessage());
		}
	}
	@Transactional
	public void update(Client client) {
		try {
			Integer clientId = client.getID();
			if (isExist(clientId)) {
				Client oldClient = repository.getById(clientId);
				oldClient.setLastName(client.getLastName());
				oldClient.setMobile(client.getMobile());
				oldClient.setName(client.getName());
				repository.save(oldClient);
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
