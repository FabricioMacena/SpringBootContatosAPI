package com.example.demo.controllers.dtos;

import java.util.List;

import com.example.demo.models.ContactModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ContactResponseDto {

	@JsonInclude(Include.NON_NULL)
	private List<ContactModel> contacts;

	@JsonInclude(Include.NON_NULL)
	private ContactModel contact;

	@JsonInclude(Include.NON_NULL)
	private String message;
	
	public List<ContactModel> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ContactModel getContact() {
		return contact;
	}
	public void setContact(ContactModel contact) {
		this.contact = contact;
	}
	
	
}
