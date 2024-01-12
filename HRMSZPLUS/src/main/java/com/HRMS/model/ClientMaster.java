package com.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_clients")
public class ClientMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientID;
	
	private String ClientName;
	private String ContactPerson;
	private String ContactNumber;
	private String Email;
	private String Address;
	private String Website;
	private String Notes;
	
	
	
	
	
	
	
	public ClientMaster() {
		super();
	}
	public ClientMaster(int clientID, String clientName, String contactPerson, String contactNumber, String email,
			String address, String website, String notes) {
		super();
		ClientID = clientID;
		ClientName = clientName;
		ContactPerson = contactPerson;
		ContactNumber = contactNumber;
		Email = email;
		Address = address;
		Website = website;
		Notes = notes;
	}
	@Override
	public String toString() {
		return "ClientMaster [ClientID=" + ClientID + ", ClientName=" + ClientName + ", ContactPerson=" + ContactPerson
				+ ", ContactNumber=" + ContactNumber + ", Email=" + Email + ", Address=" + Address + ", Website="
				+ Website + ", Notes=" + Notes + "]";
	}
	public int getClientID() {
		return ClientID;
	}
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
}
