package org.kamil.invoice.domain;

public class Client {
	private String nip;
	private String name;
	private String city;
	private String post;
	private String street;
	private String clientId;
	
	public Client() {
		super();
	}
	
	public Client(String nip, String name, String city, String post, String street, String clientId) {
		super();
		this.nip = nip;
		this.name = name;
		this.city = city;
		this.post = post;
		this.street = street;
		this.clientId = clientId;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
			
}
