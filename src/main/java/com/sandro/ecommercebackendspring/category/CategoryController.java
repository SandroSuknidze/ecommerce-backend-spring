package com.sandro.ecommercebackendspring.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://ecommerce-frontend-kappa-ten.vercel.app")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Map<String, Object>>> getAllCategories() {
        List<Map<String, Object>> categories = categoryService.getAllCategoriesWithProductCount();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Map<String, Object>>> getCategoryById(@PathVariable Long categoryId) {
        List<Map<String, Object>> category = categoryService.getCategoryById(categoryId);

        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(List.of(Map.of("message", "Category not found")));
        }

        return ResponseEntity.ok(category);
    }
}
