package org.kamil.invoice.domain.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.kamil.invoice.domain.Client;

public class ClientDao {
	
	Connection conn = null;
	Statement stat = null;
	
	public ClientDao(Statement statement) {
		this.stat = statement;		
	}
	
	public void create_table() {
		String table_create = "CREATE TABLE IF NOT EXISTS clients(clientId varchar(16), nip varchar(16), name varchar(32), "
				+ "city varchar(32), post varchar(32), street varchar(36));";
		
		try {
			stat.executeUpdate(table_create);			
		} catch (SQLException e){
            System.err.println("CLIENTS | Create table error "+ e.getMessage() );
            System.exit(0);
        }
	}
	
	public ArrayList<Client> select_allClients(){
		ArrayList<Client> table_clients = new ArrayList<Client>();
		String query = "SELECT clientId, nip, name, city, post, street FROM clients;";
		
		try {
			ResultSet rs_clients = stat.executeQuery(query);
			while(rs_clients.next()) {
				String nip = rs_clients.getString("nip");
				String name = rs_clients.getString("name");
				String city = rs_clients.getString("city");
				String post = rs_clients.getString("post");
				String street = rs_clients.getString("street");
				String clientId = rs_clients.getString("clientId");
				Client client = new Client(nip, name, city, post, street, clientId);
				table_clients.add(client);
			}
		} catch (SQLException e) {
			System.err.println("CLIENTS | Select all error "+ e.getMessage() );
            System.exit(0);
		}
		
		return table_clients;
	}
	
	public Client select_client(String clientId) {
		String query = "SELECT clientId, nip, name, city, post, street FROM clients"
				+ " where clientId = " + clientId + ";";
		Client client = null;
		
		try {
			ResultSet rs_client = stat.executeQuery(query);
			while(rs_client.next()) {
				String nip = rs_client.getString("nip");
				String name = rs_client.getString("name");
				String city = rs_client.getString("city");
				String post = rs_client.getString("post");
				String street = rs_client.getString("street");				
				client = new Client(nip, name, city, post, street, clientId);				
			}
		} catch (SQLException e) {
			System.err.println("CLIENTS | Select where id error "+ e.getMessage() );
            System.exit(0);
		}
		
		return client;
	}
	
	public Map<String, String> select_clientsMap(){
		Map<String, String> clientsMap = new HashMap<String, String>();
		String query = "SELECT clientId, name FROM clients;";
		
		try {
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				String clientId = rs.getString("clientId");
				clientsMap.put(clientId, name);
			}
		} catch (SQLException e) {
			System.err.println("CLIENTS | Select map "+ e.getMessage() );
            System.exit(0);
		}
		
		return clientsMap;
	}
	
	public void insert_client(Client client) {
		String query_full = null;
		String query_prefix = "INSERT INTO clients (clientId, nip, name, city, post, street) VALUES ";
		String query_content = "('" + client.getClientId() + "', '" + client.getNip() + "', '" + client.getName()
			+ "', '" + client.getCity() + "', '" + client.getPost() + "', '" + client.getStreet() + "');";
		query_full = query_prefix + query_content;
		
		try {
			stat.execute(query_full);
			System.out.println("CLIENTS | Insert OK");
		} catch (SQLException e) {
			System.err.println("CLIENTS | Insert error "+ e.getMessage() );
            System.exit(0);
		}
	}

}
