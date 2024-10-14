package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.brand.Brand;
import com.sandro.ecommercebackendspring.brand.BrandRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BrandSeeder {

    private final BrandRepository brandRepository;

    @PostConstruct
    public void seedBrands() {
        if (brandRepository.count() == 0) {
            List<Brand> brands = Arrays.asList(
                    new Brand("Adrianna Papell"),
                    new Brand("AG - Adriano"),
                    new Brand("Aglini"),
                    new Brand("Alberta Ferretti"),
                    new Brand("Bally"),
                    new Brand("Baxton Studio"),
                    new Brand("BaubleBar"),
                    new Brand("Bcbgmaxazria"),
                    new Brand("Cafènoir"),
                    new Brand("Casadei"),
                    new Brand("C.P. Company"),
                    new Brand("Certified International"),
                    new Brand("Umino")
            );

            brandRepository.saveAll(brands);
        }
    }
}
