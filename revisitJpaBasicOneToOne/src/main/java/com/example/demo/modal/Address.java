package com.example.demo.modal;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="address")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {
	
	@Id
	@Column(name = "user_id")
	private Long id;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

}
