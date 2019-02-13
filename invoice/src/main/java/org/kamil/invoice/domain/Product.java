package org.kamil.invoice.domain;

public class Product {
	private String productId;
	private String name;	
	private float quantity;
	private float netto;
	private float brutto;
	private float tax;
	private float sumNetto;
	private float sumBrutto;
	private float sumTax;
	private String documentId;
		
	public Product() {
		super();
	}
		
	public Product(String productId, String name, float quantity,
			float netto, float brutto, float tax, String documentId) {
		super();
		this.name = name;
		this.productId = productId;
		this.quantity = quantity;
		this.netto = netto;
		this.brutto = brutto;
		this.tax = tax;
		this.sumNetto = netto * quantity;
		this.sumBrutto = brutto * quantity;
		this.sumTax = tax * quantity;
		this.documentId = documentId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
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

	public float getSumNetto() {
		return sumNetto;
	}

	public void setSumNetto(float sumNetto) {
		this.sumNetto = sumNetto;
	}

	public float getSumBrutto() {
		return sumBrutto;
	}

	public void setSumBrutto(float sumBrutto) {
		this.sumBrutto = sumBrutto;
	}

	public float getSumTax() {
		return sumTax;
	}

	public void setSumTax(float sumTax) {
		this.sumTax = sumTax;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}		
		
}
