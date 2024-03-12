package com.example.demo.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_contatos")
public class ContactModel implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idContact;
	private String name;
	private String lastName;
	private int age;
	private String nacionality;
	private String email;
	
	public UUID getIdContact() {
		return idContact;
	}
	public void setIdContact(UUID idContact) {
		this.idContact = idContact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNacionality() {
		return nacionality;
	}
	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversion() {
		return serialVersionUID;
	}
	
	
	
}
