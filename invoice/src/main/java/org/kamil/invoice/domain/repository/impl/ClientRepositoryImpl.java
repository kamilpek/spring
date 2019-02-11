package org.kamil.invoice.domain.repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Client;
import org.kamil.invoice.domain.dao.ClientDao;
import org.kamil.invoice.domain.dao.DatabaseDao;
import org.kamil.invoice.domain.repository.ClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
	
	private List<Client> listOfClients = new ArrayList<Client>();
	private Map<String, String> clientsMap = new HashMap<String, String>();
	private DatabaseDao database = DatabaseDao.getDb();
	private Statement dbStatement = database.stat;
	private ClientDao clientDao = new ClientDao(dbStatement);
	
	public ClientRepositoryImpl() {
		super();
		clientDao.create_table();
	}
	
	public List<Client> getAllClients() {
		listOfClients = clientDao.select_allClients();
		return listOfClients;
	}

	public Client getClientById(String clientId) {
		Client client = clientDao.select_client(clientId);
		return client;
	}
	
	public Map<String, String> getClientsMap(){
		clientsMap = clientDao.select_clientsMap();
		return clientsMap;
	}

	public void addClient(Client client) {
		clientDao.insert_client(client);
	}

}
