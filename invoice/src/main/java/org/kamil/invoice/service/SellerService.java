package org.kamil.invoice.service;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Seller;

public interface SellerService {
	
	List<Seller> getAllSellers();
	
	Seller getSellerById(String sellerId);
	
	Map<String, String> getSellersMap();
	
	void addSeller(Seller seller);

}
