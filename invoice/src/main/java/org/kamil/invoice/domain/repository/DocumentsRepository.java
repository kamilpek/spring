package org.kamil.invoice.domain.repository;

import java.util.List;

import org.kamil.invoice.domain.Document;

public interface DocumentsRepository {
	
	List<Document> getAllDocuments();
	
	Document getDocumentById(String documentId);
	
	void addDocument(Document document);

}
