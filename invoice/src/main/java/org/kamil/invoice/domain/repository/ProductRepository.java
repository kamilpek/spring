package org.kamil.invoice.domain.repository;

import java.util.List;

import org.kamil.invoice.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByInvoice(String invoice);
	
	float getNettoSumByInvoice(String invoice);
	
	float getBruttoSumByInvoice(String documentId);
	
	float getTaxSumByInvoice(String documentId);
	
	Product getProductById(String productId);
	
	void addProduct(Product product);	
}
