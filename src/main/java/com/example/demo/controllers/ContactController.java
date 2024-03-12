package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dtos.ContactRecordDto;
import com.example.demo.models.ContactModel;
import com.example.demo.repositories.ContactRepository;

import jakarta.validation.Valid;

@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@PostMapping("/contacts")
	public ResponseEntity<ContactModel> createContact(@RequestBody @Valid ContactRecordDto contactRecordDto){
		ContactModel contactModel = new ContactModel();
		BeanUtils.copyProperties(contactRecordDto, contactModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(contactRepository.save(contactModel));
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<ContactModel>> getAllContacts(){
		return ResponseEntity.status(HttpStatus.OK).body(contactRepository.findAll());
	}
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Object> getOneContact(@PathVariable(value = "id") UUID id){
		Optional<ContactModel> contact = contactRepository.findById(id);
		
		if (contact.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(contact.get());
	}
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Object> updateContact(@PathVariable(value = "id") UUID id,
												@RequestBody @Valid ContactRecordDto contactRecordDto){
		
		Optional<ContactModel> contact = contactRepository.findById(id);
		
		if (contact.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
		}
		
		ContactModel contactModel = contact.get();
		BeanUtils.copyProperties(contactRecordDto, contactModel);
		
		return ResponseEntity.status(HttpStatus.OK).body(contactRepository.save(contactModel));
	}
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<Object> deleteContact(@PathVariable(value = "id") UUID id){
		Optional<ContactModel> contact = contactRepository.findById(id);
		
		if (contact.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
		}
		
		contactRepository.delete(contact.get());
		return ResponseEntity.status(HttpStatus.OK).body("Contact successfully deleted!");
	}
}
