package org.kamil.invoice.domain.repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Document;
import org.kamil.invoice.domain.dao.DatabaseDao;
import org.kamil.invoice.domain.dao.DocumentDao;
import org.kamil.invoice.domain.repository.DocumentsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentRepositoryImpl implements DocumentsRepository {
	
	private List<Document> listOfDocuments = new ArrayList<Document>();
	private Map<String, String> documentsMap = new HashMap<String, String>();
	private DatabaseDao database = DatabaseDao.getDb();
	private Statement dbStatement = database.stat;
	private DocumentDao documentDao = new DocumentDao(dbStatement);

	public DocumentRepositoryImpl() {
		super();		
		documentDao.create_table();
	}
	
	public List<Document> getAllDocuments() {
		listOfDocuments = documentDao.select_alldocuments();		
		return listOfDocuments;
	}
	
	public Document getDocumentById(String documentId) {
		Document documentById = documentDao.select_document(documentId);				
		return documentById;
	}
	
	public Map<String, String> getDocumentsMap(){
		documentsMap = documentDao.select_documentsMap();
		return documentsMap;
	}
	
	public void addDocument(Document document) {
		documentDao.insert_document(document);
	}
	
	public void updateDocument(String documentId, String column, String value) {
		documentDao.update_document(documentId, column, value);
	}

}
