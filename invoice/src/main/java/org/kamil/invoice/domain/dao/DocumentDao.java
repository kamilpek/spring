package org.kamil.invoice.domain.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kamil.invoice.domain.Document;

public class DocumentDao {
	
	Connection conn = null;
	Statement stat = null;
	
	public DocumentDao(Statement statement){
		this.stat = statement;
	}
	
	public void create_table() {
		String table_create = "CREATE TABLE IF NOT EXISTS documents(documentId serial, documentNumber integer not null, "
				+ "city varchar(32) not null, date varchar(16) not null, term varchar(16) not null, payment varchar(32) not null, "
				+ "netto real, brutto real, tax real, clientId varchar(16), sellerId varchar(16));";
		
		try {
			stat.executeUpdate(table_create);			
		} catch (SQLException e){
            System.err.println("DOCUMENTS | Create table error "+ e.getMessage() );
            System.exit(0);
        }
	}
	
	public ArrayList<Document> select_alldocuments(){
		ArrayList<Document> table_documents = new ArrayList<Document>();		
		String query = "SELECT documentId, documentNumber, city, date, term, payment, netto, brutto, tax, clientId, sellerId from documents;";
		
		try {
			ResultSet rs_documents = stat.executeQuery(query);
			while(rs_documents.next()) {		
				String documentId = rs_documents.getString("documentId");
				String documentNumber = rs_documents.getString("documentNumber");
				String city = rs_documents.getString("city");
				String date = rs_documents.getString("date");
				String term = rs_documents.getString("term");
				String payment = rs_documents.getString("payment");
				String clientId = rs_documents.getString("clientId");
				String sellerId = rs_documents.getString("sellerId");
				Document document = new Document(documentId, documentNumber, city, date, term, payment, clientId, sellerId);
				table_documents.add(document);
			}
		} catch (SQLException e){
            System.err.println("DOCUMENTS | Select all error "+ e.getMessage() );
            System.exit(0);
        }
		
		return table_documents;
	}
	
	public Document select_document(String documentId) {
		String query = "SELECT documentId, documentNumber, city, date, term, payment, netto, brutto, tax, clientId, sellerId from documents"
				+ " where documentId = " + documentId + ";";	
				
		Document document = null;
		
		try {
			ResultSet rs_document = stat.executeQuery(query);
			while(rs_document.next()) {
				String documentNumber = rs_document.getString("documentNumber");
				String city = rs_document.getString("city");
				String date = rs_document.getString("date");
				String term = rs_document.getString("term");
				String payment = rs_document.getString("payment");
				String clientId = rs_document.getString("clientId");
				String sellerId = rs_document.getString("sellerId");
				document = new Document(documentId, documentNumber, city, date, term, payment, clientId, sellerId);
			}
			System.out.println("DOCUMENTS | Select where id OK");
		} catch (SQLException e) {
			 System.err.println("DOCUMENTS | Select where id error "+ e.getMessage() );
	            System.exit(0);
		}	
		
		return document;
	}
	
	public void insert_document(Document doc) {
		String query_full = null;
		String query_prefix = "INSERT INTO documents (documentId, documentNumber, city, date, term, payment, netto, brutto, tax, clientId, sellerId) VALUES";
		String query_content = "('" + doc.getDocumentId() + "', '" + doc.getDocumentNumber() + "', '" + doc.getCity()  + "', '"
				+ doc.getDate() + "', '" + doc.getTerm() + "', '" + doc.getPayment() + "', '" + doc.getNetto() + "', '" + doc.getBrutto() + "', '"
				+ doc.getTax() + "', '" + doc.getClientId() + "', '" + doc.getSellerId() +  "')";
		query_full = query_prefix + query_content;		
		try {
			stat.execute(query_full);
			System.out.println("DOCUMENTS | Insert OK");
		} catch (SQLException e) {
			System.err.println("DOCUMENTS | Insert error "+ e.getMessage() );
            System.exit(0);
		}
	}
	
}
