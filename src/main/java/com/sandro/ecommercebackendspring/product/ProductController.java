package com.sandro.ecommercebackendspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        List<Product> products = productService.getProductsByCategory(categoryId);

        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/new-arrivals")
    public List<Product> getNewArrivals() {
        return productService.getNewArrivalProducts();
    }

    @GetMapping("/products/featured")
    public List<Product> getFeaturedProducts() {
        return productService.getAllFeaturedProducts();
    }

    @GetMapping("/products/sale")
    public List<Product> getSaleProducts() {
        return productService.getAllSaleProducts();
    }

    @GetMapping("/products/random")
    public List<Product> getRandomProducts() {
        return productService.getRandomProducts();
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<Product>> getProductById(
            @RequestParam(required = false) String brands,
            @RequestParam(required = false) String colors,
            @RequestParam(required = false) String sizes,
            @RequestParam(required = false) String price,
            @PathVariable Long categoryId) {
        List<Product> products = productService.getFilteredProducts(categoryId, brands, colors, sizes, price);
        return ResponseEntity.ok(products);
    }
}
