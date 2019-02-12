package org.kamil.invoice.service;

import java.util.List;

import org.kamil.invoice.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByInvoice(String invoice);
	
	float getNettoSumByInvoice(String invoice);
	
	float getBruttoSumByInvoice(String invoice);
	
	float getTaxSumByInvoice(String invoice);	
	
	Product getProductById(String productId);
	
	void addProduct(Product product);
}
