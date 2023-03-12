package com.example.demo.serviceInterface;

import org.springframework.http.ResponseEntity;

import com.example.demo.modal.Address;

public interface AddressServiceInterface {
	
	ResponseEntity<Object> addAddress(Address address);
	
	ResponseEntity<Object> getAll();
	
	ResponseEntity<Object> getOneAddress(Long id);

}
