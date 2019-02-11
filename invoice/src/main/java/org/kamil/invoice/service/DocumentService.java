package org.kamil.invoice.service;

import java.util.List;

import org.kamil.invoice.domain.Document;

public interface DocumentService {
	
	List<Document> getAllDocuments();
	
	Document getDocumentById(String documentId);
	
	void addDocument(Document documentToBeAdded);

}
