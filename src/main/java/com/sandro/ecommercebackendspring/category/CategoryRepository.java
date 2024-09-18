package com.sandro.ecommercebackendspring.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c.id, c.name, c.imagePath, COUNT(p.id) AS productCount " +
            "FROM Category c " +
            "LEFT JOIN c.products p " +
            "GROUP BY c.id, c.name, c.imagePath " +
            "HAVING COUNT(p.id) > 0")
    List<Object[]> findAllCategoriesWithProductCount();

    @Query("SELECT id, name FROM Category WHERE id = :id")
    List<Object[]> findAllCategoriesById(Long id);
}
