package com.sandro.ecommercebackendspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // It should've been products, and it should be a Get method
    @PostMapping("/product/search")
    public ResponseEntity<Object> getProductsByName(@RequestParam String q) {
        if (q.length() < 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("error", "Query string must be at least 3 characters long")
            );
        }

        List<Product> products = productService.getSearchedProducts(q);

        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "Product not found")
            );
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        if(product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "Product not found")
            );
        }
        return ResponseEntity.ok(product);
    }


}
