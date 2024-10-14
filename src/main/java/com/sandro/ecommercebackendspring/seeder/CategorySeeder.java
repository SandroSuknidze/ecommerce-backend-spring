package com.sandro.ecommercebackendspring.seeder;


import com.sandro.ecommercebackendspring.category.Category;
import com.sandro.ecommercebackendspring.category.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategorySeeder {

    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void seedCategories() {
        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.asList(
                    new Category("Womens Shirts", "uploads/categories/women's-shirts.webp"),
                    new Category("Winter Coat", "uploads/categories/winter-coat.webp"),
                    new Category("Sportswear", "uploads/categories/sportswear.webp"),
                    new Category("Dresses", "uploads/categories/dresses.webp"),
                    new Category("Top T-Shirt", "uploads/categories/top-t-shirt.webp"),
                    new Category("Sweaters", "uploads/categories/sweaters.webp"),
                    new Category("Overalls", "uploads/categories/overalls.webp"),
                    new Category("Underwear", "uploads/categories/underwear.webp"),
                    new Category("Denim Shirt", "uploads/categories/denim-shirt.webp")
            );

            categoryRepository.saveAll(categories);
        }
    }
}
