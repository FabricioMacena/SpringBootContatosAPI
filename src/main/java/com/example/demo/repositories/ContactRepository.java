package com.example.demo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ContactModel;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, UUID>{
	
	@Query("SELECT c FROM ContactModel c WHERE c.nacionality = :nacionality")
	List<ContactModel>findAllByNacionality(String nacionality, Sort sort);
}
