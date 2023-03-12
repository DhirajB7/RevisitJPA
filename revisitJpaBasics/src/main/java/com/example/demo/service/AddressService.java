package com.example.demo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Address;
import com.example.demo.repository.AddressRepo;
import com.example.demo.serviceInterface.AddressServiceInterface;

@Service
public class AddressService implements AddressServiceInterface {

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public ResponseEntity<Object> addAddress(Address address) {
		Object returnData;

		HttpStatus httpCode;

		boolean idExist = addressRepo.findAll().stream().map(oneAddress -> oneAddress.getAddressId())
				.collect(Collectors.toList()).contains(address.getAddressId());

		if (idExist) {
			returnData = "DATA ALREADY PRESENT";
			httpCode = HttpStatus.CONFLICT;
		} else {
			returnData = addressRepo.save(address);
			httpCode = HttpStatus.CREATED;
		}

		return new ResponseEntity<>(returnData, httpCode);
	}

	@Override
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<>(addressRepo.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getOneAddress(Long id) {
		Object returnData;

		HttpStatus httpCode;

		boolean idExist = addressRepo.findAll().stream().map(oneAddress -> oneAddress.getAddressId())
				.collect(Collectors.toList()).contains(id);

		if (idExist) {
			
			returnData = addressRepo.findById(id);
			
			httpCode = HttpStatus.OK;
			
		} else {
			
			returnData = "Data Not Found";
			
			httpCode = HttpStatus.NOT_FOUND;
			
		}
		
		return new ResponseEntity<>(returnData,httpCode);
	}

}
