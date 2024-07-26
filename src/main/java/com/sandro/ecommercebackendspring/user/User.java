package com.sandro.ecommercebackendspring.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    @Column(unique = true)
    private String email;

    private String password;
}
