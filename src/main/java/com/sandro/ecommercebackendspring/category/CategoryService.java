package com.sandro.ecommercebackendspring.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Map<String, Object>> getAllCategoriesWithProductCount() {
        List<Object[]> results = categoryRepository.findAllCategoriesWithProductCount();

        List<Map<String, Object>> categoriesWithProductCount = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> categoryData = new HashMap<>();
            categoryData.put("id", result[0]);
            categoryData.put("name", result[1]);
            categoryData.put("image_path", result[2]);
            categoryData.put("product_count", result[3]);

            categoriesWithProductCount.add(categoryData);
        }

        return categoriesWithProductCount;
    }

    public List<Map<String, Object>> getCategoryById(Long categoryId) {
        List<Object[]> results = categoryRepository.findAllCategoriesById(categoryId);

        List<Map<String, Object>> category = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> categoryData = new HashMap<>();
            categoryData.put("id", result[0]);
            categoryData.put("name", result[1]);

            category.add(categoryData);
        }

        return category;
    }
}
