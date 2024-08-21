package com.sandro.ecommercebackendspring.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotEmpty(message = "First name cannot be empty")
    @NotNull(message = "First name is required")
    private String first_name;

    @NotEmpty(message = "Last name cannot be empty")
    @NotNull(message = "Last name is required")
    private String last_name;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;
}
