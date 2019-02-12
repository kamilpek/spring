package org.kamil.invoice.service;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Document;

public interface DocumentService {
	
	List<Document> getAllDocuments();
	
	Document getDocumentById(String documentId);
	
	Map<String, String> getDocumentsMap();
	
	void addDocument(Document documentToBeAdded);
	
	void updateDocument(String documentId, String column, String value);
}
