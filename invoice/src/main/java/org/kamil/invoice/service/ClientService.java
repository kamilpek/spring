package org.kamil.invoice.service;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Client;

public interface ClientService {
	
	List<Client> getAllClients();
	
	Client getClientById(String clientId);
	
	Map<String, String> getClientsMap();
	
	void addClient(Client client);
}
