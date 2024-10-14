package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.size.SizeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SizeSeeder {

    private final SizeRepository sizeRepository;

    @PostConstruct
    public void seedSizes() {
        if (sizeRepository.count() == 0) {
            List<Size> sizes = Arrays.asList(
                    new Size("XS"),
                    new Size("S"),
                    new Size("M"),
                    new Size("L"),
                    new Size("XL"),
                    new Size("XXl")
            );

            sizeRepository.saveAll(sizes);
        }
    }
}
