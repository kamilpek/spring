package org.kamil.invoice.domain.repository.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.kamil.invoice.domain.Document;
import org.kamil.invoice.domain.dao.DatabaseDao;
import org.kamil.invoice.domain.dao.DocumentDao;
import org.kamil.invoice.domain.repository.DocumentsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentRepositoryImpl implements DocumentsRepository {
	
	private List<Document> listOfDocuments = new ArrayList<Document>();
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
	
	public void addDocument(Document document) {
		documentDao.insert_document(document);
	}

}
