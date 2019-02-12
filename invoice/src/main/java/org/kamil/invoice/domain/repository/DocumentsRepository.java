package org.kamil.invoice.domain.repository;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Document;

public interface DocumentsRepository {
	
	List<Document> getAllDocuments();
	
	Document getDocumentById(String documentId);
	
	Map<String, String> getDocumentsMap();
	
	void addDocument(Document document);
	
	void updateDocument(String documentId, String column, String value);
}
