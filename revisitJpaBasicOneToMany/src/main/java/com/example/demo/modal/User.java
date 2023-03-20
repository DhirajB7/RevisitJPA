package com.example.demo.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_user_id",referencedColumnName = "user_id")           //foreign  key in current table
    private List<Address> address;

}
