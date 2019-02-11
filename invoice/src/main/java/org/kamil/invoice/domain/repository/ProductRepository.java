package org.kamil.invoice.domain.repository;

import java.util.List;

import org.kamil.invoice.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByInvoice(String invoice);
	
	Product getProductById(String productId);
	
	void addProduct(Product product);	
}
