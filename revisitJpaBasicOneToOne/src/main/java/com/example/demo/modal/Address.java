package com.example.demo.modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String street;

    private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String state;

    /*
     *	1. Below code makes Bi directional One To One Mapping.
     *	2. Mapped by "address" is property of User class.
     *  3. uni direction one to one , is enough but if User reference is needed in Address, we can use bidirectional mapping.
     *  4. Way data resides in table are still same.
     * 	5.  : IMP : Make sure to exclude User user (else error will be thrown) in response so do not add getter (& setter).
     * 	6.  : IMP : USER class has ownership of one to one, in this class User is just reference so avoid getter & setter here.
     */
    @OneToOne(mappedBy = "address")
    private User user;

}
