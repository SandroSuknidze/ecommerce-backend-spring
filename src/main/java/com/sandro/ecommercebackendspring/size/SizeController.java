package com.sandro.ecommercebackendspring.size;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// This /auth is temporary and needs to be change
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SizeController {

    private final SizeService sizeService;

    @GetMapping("/sizes")
    public List<Size> getSizes() {
        return sizeService.getAllSizes();
    }
}
