package com.example.demo.modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String street;

    private String city;

    private String state;

}
