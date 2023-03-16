package com.example.demo.modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)  //mappedBy is entity name starting in lower case
    @PrimaryKeyJoinColumn
    private Address address;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
