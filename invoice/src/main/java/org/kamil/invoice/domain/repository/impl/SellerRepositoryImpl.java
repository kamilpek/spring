package org.kamil.invoice.domain.repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Seller;
import org.kamil.invoice.domain.dao.DatabaseDao;
import org.kamil.invoice.domain.dao.SellerDao;
import org.kamil.invoice.domain.repository.SellerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepositoryImpl implements SellerRepository {
	
	private List<Seller> listOfSellers = new ArrayList<Seller>();
	private	Map<String, String> sellersMap = new HashMap<String, String>();
	private DatabaseDao database = DatabaseDao.getDb();
	private Statement dbStatement = database.stat;	
	private SellerDao sellerDao = new SellerDao(dbStatement);
	
	public SellerRepositoryImpl() {
		super();
		sellerDao.create_table();
	}

	public List<Seller> getAllSellers() {
		listOfSellers = sellerDao.select_allSellers();
		return listOfSellers;
	}

	public Seller getSellerById(String sellerId) {
		Seller seller = sellerDao.select_seller(sellerId);
		return seller;		
	}
	
	public Map<String, String> getSellersMap() {
		sellersMap = sellerDao.select_sellersMap();
		return sellersMap;
	}

	public void addSeller(Seller seller) {
		sellerDao.insert_seller(seller);
	}

}
