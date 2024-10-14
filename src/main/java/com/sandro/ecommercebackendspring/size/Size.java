package com.sandro.ecommercebackendspring.size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sandro.ecommercebackendspring.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "sizes")
@Getter
@Setter
@NoArgsConstructor
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "sizes", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Size(String name) {
        this.name = name;
    }
}
