package com.sandro.ecommercebackendspring.brand;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
}
