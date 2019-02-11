package org.kamil.invoice.service.impl;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Seller;
import org.kamil.invoice.domain.repository.SellerRepository;
import org.kamil.invoice.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<Seller> getAllSellers(){
		return sellerRepository.getAllSellers();
	}
	
	public Seller getSellerById(String sellerId) {
		return sellerRepository.getSellerById(sellerId);
	}
	
	public Map<String, String> getSellersMap(){
		return sellerRepository.getSellersMap();
	}
	
	public void addSeller(Seller seller) {
		sellerRepository.addSeller(seller);
	}
	

}
