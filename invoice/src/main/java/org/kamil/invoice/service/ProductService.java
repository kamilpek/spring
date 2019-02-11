package org.kamil.invoice.service;

import java.util.List;

import org.kamil.invoice.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByInvoice(String invoice);
	
	Product getProductById(String productId);
	
	void addProduct(Product product);
}
