package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Address;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public ResponseEntity<Object> getAllAddress() {
		return addressService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getAddressById(@PathVariable("id") Long id) {

		return addressService.getOneAddress(id);

	}

	@PostMapping
	public ResponseEntity<Object> addAddress(@RequestBody Address address) {

		return addressService.addAddress(address);
		
	}

}
