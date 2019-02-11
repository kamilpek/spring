package org.kamil.invoice.service.impl;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Client;
import org.kamil.invoice.domain.repository.ClientRepository;
import org.kamil.invoice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.getAllClients();
	}

	public Client getClientById(String clientId) {
		return clientRepository.getClientById(clientId);
	}
	
	public Map<String, String> getClientsMap(){
		return clientRepository.getClientsMap();
	}

	public void addClient(Client client) {
		clientRepository.addClient(client);
	}	

}
