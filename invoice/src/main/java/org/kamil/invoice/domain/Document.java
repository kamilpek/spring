package org.kamil.invoice.domain;

public class Document {
	private String documentId;
	private String documentNumber;
	private String city;
	private String date;
	private String term;
	private String payment;
	private float netto;
	private float brutto;
	private float tax;
	private String clientId;
	private String sellerId;
	
	public Document(String documentId, String documentNumber, String city, String date, String term, 
			String payment, String clientId, String sellerId) {
		super();
		this.documentId = documentId;
		this.documentNumber = documentNumber;
		this.city = city;
		this.date = date;
		this.term = term;
		this.payment = payment;
		this.netto = 0;
		this.brutto = 0;
		this.tax = 0;
		this.clientId = clientId;
		this.sellerId = sellerId;
	}

	public Document() {
		super();
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public float getNetto() {
		return netto;
	}

	public void setNetto(float netto) {
		this.netto = netto;
	}

	public float getBrutto() {
		return brutto;
	}

	public void setBrutto(float brutto) {
		this.brutto = brutto;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}	
	
}
