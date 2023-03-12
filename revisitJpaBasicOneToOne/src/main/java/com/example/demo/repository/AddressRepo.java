package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
