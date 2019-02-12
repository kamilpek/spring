package org.kamil.invoice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.kamil.invoice.domain.Product;
import org.kamil.invoice.domain.repository.ProductRepository;
import org.kamil.invoice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
		
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	public List<Product> getProductsByInvoice(String invoice){
		return productRepository.getProductsByInvoice(invoice);
	}
	
	public float getNettoSumByInvoice(String invoice) {
		return productRepository.getNettoSumByInvoice(invoice);
	}
	
	public float getBruttoSumByInvoice(String invoice) {
		return productRepository.getBruttoSumByInvoice(invoice);
	}
	
	public float getTaxSumByInvoice(String invoice) {
		return productRepository.getTaxSumByInvoice(invoice);
	}
	
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}
	
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
}
