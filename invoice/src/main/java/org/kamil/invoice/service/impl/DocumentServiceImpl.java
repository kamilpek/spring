package org.kamil.invoice.service.impl;

import java.util.List;

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
	
	public void addDocument(Document document) {
		documentRepository.addDocument(document);
	}
}
