package com.sandro.ecommercebackendspring.color;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sandro.ecommercebackendspring.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "colors")
@Getter
@Setter
@NoArgsConstructor
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @JsonIgnore
    @ManyToMany(mappedBy = "colors", fetch = FetchType.LAZY)
    private Set<Product> products;
}
