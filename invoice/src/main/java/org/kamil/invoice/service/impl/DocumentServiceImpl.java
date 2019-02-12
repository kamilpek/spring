package org.kamil.invoice.service.impl;

import java.util.List;
import java.util.Map;

import org.kamil.invoice.domain.Document;
import org.kamil.invoice.domain.repository.DocumentsRepository;
import org.kamil.invoice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentsRepository documentRepository;
	
	public List<Document> getAllDocuments(){
		return documentRepository.getAllDocuments();
	}
	
	public Document getDocumentById(String documentId) {
		return documentRepository.getDocumentById(documentId);
	}
	
	public Map<String, String> getDocumentsMap(){
		return documentRepository.getDocumentsMap();
	}
	
	public void addDocument(Document document) {
		documentRepository.addDocument(document);
	}
	
	public void updateDocument(String documentId, String column, String value) {
		documentRepository.updateDocument(documentId, column, value);
	}
}
