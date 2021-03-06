package org.kamil.invoice.domain.repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.kamil.invoice.domain.Product;
import org.kamil.invoice.domain.dao.DatabaseDao;
import org.kamil.invoice.domain.dao.ProductDao;
import org.kamil.invoice.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private List<Product> listOfProducts = new ArrayList<Product>();
	private DatabaseDao database = DatabaseDao.getDb();
	private Statement dbStatement = database.stat;
	private ProductDao productDao = new ProductDao(dbStatement);
	
	public ProductRepositoryImpl() {
		super();
		productDao.create_table();
	}
	
	public List<Product> getAllProducts() {
		listOfProducts = productDao.select_allproducts();
		return listOfProducts;
	}
	
	public List<Product> getProductsByInvoice(String documentId) {		
		listOfProducts = productDao.select_product_wheredocument(documentId);
		return listOfProducts;
	}
	
	public float getNettoSumByInvoice(String documentId) {
		return productDao.select_nettosum(documentId);
	}
	
	public float getBruttoSumByInvoice(String documentId) {
		return productDao.select_bruttosum(documentId);
	}
	
	public float getTaxSumByInvoice(String documentId) {
		return productDao.select_taxsum(documentId);
	}
	
	public Product getProductById(String productId) {
		Product productById = productDao.select_product_whereid(productId);				
		return productById;
	}
	
	public void addProduct(Product product) {
		productDao.insert_product(product);
	}

}
