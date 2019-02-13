package org.kamil.invoice.domain.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kamil.invoice.domain.Product;

public class ProductDao {
	
	Connection conn = null;
	Statement stat = null;
	
	public ProductDao(Statement statement) {
		this.stat = statement;
	}
	
	public void create_table() {
		String table_create = "CREATE TABLE IF NOT EXISTS products(productId serial, quantity real not null, "
				+ "name varchar(32) not null, netto real not null, brutto real not null, tax real not null, "
				+ "sumNetto real, sumBrutto real, sumTax real, documentId varchar(16));";
		
		try {			
			stat.executeUpdate(table_create);			
		} catch (SQLException e){
            System.err.println("PRODUCTS | Create table error "+ e.getMessage() );
            System.exit(0);
        }
	}
	
	public ArrayList<Product> select_allproducts(){
		ArrayList<Product> table_products = new ArrayList<Product>();
		String query = "SELECT productId, quantity, name, netto, brutto, tax, sumNetto, sumBrutto, sumTax, documentId"
				+ " from products;";
		
		try {
			ResultSet rs_products = stat.executeQuery(query);
			while(rs_products.next()) {
				String productId = rs_products.getString("productId");
				String name = rs_products.getString("name");
				float quantity = rs_products.getFloat("quantity");
				float netto = rs_products.getFloat("netto");
				float brutto = rs_products.getFloat("brutto");
				float tax = rs_products.getFloat("tax");
				String documentId = rs_products.getString("documentId");
				Product product = new Product(productId, name, quantity, netto, brutto, tax, documentId);
				table_products.add(product);
			}
		} catch (SQLException e) {
			 System.err.println("PRODUCTS | Select all error "+ e.getMessage() );
	         System.exit(0);
		}
		
		return table_products;		
	}
	
	public Product select_product_whereid(String productId) {
		String query = "SELECT productId, quantity, name, netto, brutto, tax, sumNetto, sumBrutto, sumTax, documentId"
				+ " from products where productId = " + productId + ";";
		Product product = null;
		
		try {
			ResultSet rs_product = stat.executeQuery(query);
			while(rs_product.next()) {				
				String name = rs_product.getString("name");
				float quantity = rs_product.getFloat("quantity");
				float netto = rs_product.getFloat("netto");
				float brutto = rs_product.getFloat("brutto");
				float tax = rs_product.getFloat("tax");
				String documentId = rs_product.getString("documentId");
				product = new Product(productId, name, quantity, netto, brutto, tax, documentId);
			}
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Select where id error "+ e.getMessage() );
	        System.exit(0);
		}
		
		return product;		
	}
	
	public ArrayList<Product> select_product_wheredocument(String documentId) {
		ArrayList<Product> table_products = new ArrayList<Product>();
		String query = "SELECT productId, quantity, name, netto, brutto, tax, sumNetto, sumBrutto, sumTax, documentId"
				+ " from products where documentId = " + documentId + ";";		
		
		try {
			ResultSet rs_product = stat.executeQuery(query);
			while(rs_product.next()) {				
				String name = rs_product.getString("name");
				float quantity = rs_product.getFloat("quantity");
				float netto = rs_product.getFloat("netto");
				float brutto = rs_product.getFloat("brutto");
				float tax = rs_product.getFloat("tax");
				String productId = rs_product.getString("productId");
				Product product = new Product(productId, name, quantity, netto, brutto, tax, documentId);
				table_products.add(product);
			}
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Select where document error "+ e.getMessage() );
	        System.exit(0);
		}
		
		return table_products;
	}
	
	public float select_nettosum(String documentId) {
		String query = "SELECT sum(netto) as sum_netto from products where documentId = " + documentId;
		float nettosum = 0;
		
		try {
			ResultSet rs = stat.executeQuery(query);
			nettosum = rs.getFloat("sum_netto");
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Select netto sum where document error "+ e.getMessage() );
	        System.exit(0);
		}
		
		return nettosum;
	}
	
	public float select_bruttosum(String documentId) {
		String query = "SELECT sum(sumBrutto) as sum_brutto from products where documentId = " + documentId;
		float bruttosum = 0;
		
		try {
			ResultSet rs = stat.executeQuery(query);
			bruttosum = rs.getFloat("sum_brutto");
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Select brutto sum where document error "+ e.getMessage() );
	        System.exit(0);
		}
		
		return bruttosum;
	}
	
	public float select_taxsum(String documentId) {
		String query = "SELECT sum(sumTax) as sum_tax from products where documentId = " + documentId;
		float taxsum = 0;
		
		try {
			ResultSet rs = stat.executeQuery(query);
			taxsum = rs.getFloat("sum_tax");
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Select tax sum where document error "+ e.getMessage() );
	        System.exit(0);
		}
		
		return taxsum;
	}
	
	public void insert_product(Product prod) {		
		String query_prefix = "INSERT INTO products (productId, quantity, name, netto, brutto, tax, sumNetto, sumBrutto, sumTax, documentId) VALUES ";
		String query_content = "('" + prod.getProductId() + "', '" + prod.getQuantity() + "', '" + prod.getName() + "', '" + prod.getNetto() + "', '"
				+ prod.getBrutto() + "', '" + prod.getTax() + "', '" + prod.getSumNetto() + "', '" + prod.getBrutto() + "', '" + prod.getTax() + "', '"
				+ prod.getDocumentId() + "');";
		String query_full = query_prefix + query_content;
		
		try {
			stat.execute(query_full);
			System.out.println("PRODUCTS | Insert OK ");
		} catch (SQLException e) {
			System.err.println("PRODUCTS | Insert error "+ e.getMessage() );
            System.exit(0);
		}
	}

}
