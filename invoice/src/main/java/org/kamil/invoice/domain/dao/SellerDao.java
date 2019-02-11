package org.kamil.invoice.domain.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.kamil.invoice.domain.Seller;

public class SellerDao {
	
	Connection conn = null;
	Statement stat = null;
		
	public SellerDao(Statement statement) {
		this.stat = statement;
	}
	
	public void create_table() {
		String table_create = "CREATE TABLE IF NOT EXISTS sellers(sellerId varchar(16), nip varchar(16), name varchar(32), "
				+ "city varchar(32), post varchar(32), street varchar(36));";
		
		try {
			stat.executeUpdate(table_create);			
		} catch (SQLException e){
            System.err.println("SELLERS | Create table error "+ e.getMessage() );
            System.exit(0);
        }
	}
	
	public ArrayList<Seller> select_allSellers(){
		ArrayList<Seller> table_sellers = new ArrayList<Seller>();
		String query = "SELECT sellerId, nip, name, city, post, street FROM sellers;";
		
		try {
			ResultSet rs_sellers = stat.executeQuery(query);
			while(rs_sellers.next()) {
				String nip = rs_sellers.getString("nip");
				String name = rs_sellers.getString("name");
				String city = rs_sellers.getString("city");
				String post = rs_sellers.getString("post");
				String street = rs_sellers.getString("street");
				String sellerId = rs_sellers.getString("sellerId");
				Seller seller = new Seller(nip, name, city, post, street, sellerId);
				table_sellers.add(seller);
			}
		} catch (SQLException e) {
			System.err.println("SELLERS | Select all error "+ e.getMessage() );
            System.exit(0);
		}
		
		return table_sellers;
	}
	
	public Seller select_seller(String sellerId) {
		String query = "SELECT nip, name, city, post, street FROM sellers"
				+ " where sellerId = " + sellerId + ";";
		Seller seller = null;
		
		try {
			ResultSet rs_seller = stat.executeQuery(query);
			while(rs_seller.next()) {
				String nip = rs_seller.getString("nip");
				String name = rs_seller.getString("name");
				String city = rs_seller.getString("city");
				String post = rs_seller.getString("post");
				String street = rs_seller.getString("street");				
				seller = new Seller(nip, name, city, post, street, sellerId);				
			}
		} catch (SQLException e) {
			System.err.println("SELLERS | Select where id error "+ e.getMessage() );
            System.exit(0);
		}
		
		return seller;
	}
	
	public Map<String, String> select_sellersMap(){
		Map<String, String> sellersMap = new HashMap<String, String>();
		String query = "SELECT sellerId, name FROM sellers;";
		
		try {
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				String sellerId = rs.getString("sellerId");
				sellersMap.put(sellerId, name);
			}
		} catch (SQLException e) {
			System.err.println("SELLERS | Select map "+ e.getMessage() );
            System.exit(0);
		}
		
		return sellersMap;
	}
	
	public void insert_seller(Seller seller) {
		String query_full = null;
		String query_prefix = "INSERT INTO sellers (sellerId, nip, name, city, post, street) VALUES ";
		String query_content = "('" + seller.getSellerId() + "', '" + seller.getNip() + "', '" + seller.getName()
			+ "', '" + seller.getCity() + "', '" + seller.getPost() + "', '" + seller.getStreet() + "');";
		query_full = query_prefix + query_content;
		
		try {
			stat.execute(query_full);
			System.out.println("SELLERS | Insert OK");
		} catch (SQLException e) {
			System.err.println("SELLERS | Insert error "+ e.getMessage() );
            System.exit(0);
		}
	}

}
