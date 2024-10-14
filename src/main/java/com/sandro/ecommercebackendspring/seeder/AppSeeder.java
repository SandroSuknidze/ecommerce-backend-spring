package com.sandro.ecommercebackendspring.seeder;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class AppSeeder implements CommandLineRunner {

    private final ColorSeeder colorSeeder;
    private final SizeSeeder sizeSeeder;
    private final BrandSeeder brandSeeder;
    private final CategorySeeder categorySeeder;
    private final ProductSeeder productSeeder;
    private final CookiePolicySeeder cookiePolicySeeder;
    private final PrivacyPolicySeeder privacyPolicySeeder;
    private final RefundPolicySeeder refundPolicySeeder;
    private final ShippingReturnSeeder shippingReturnSeeder;
    private final TermsConditionsSeeder termsConditionsSeeder;

    @Override
    public void run(String... args) throws Exception {
        if (Arrays.asList(args).contains("seed")) {
            colorSeeder.seedColors();
            sizeSeeder.seedSizes();
            brandSeeder.seedBrands();
            categorySeeder.seedCategories();
            productSeeder.seedProducts();
            cookiePolicySeeder.seedPrivacyPolicy();
            privacyPolicySeeder.seedPrivacyPolicy();
            refundPolicySeeder.seedRefundPolicy();
            shippingReturnSeeder.seedShippingReturn();
            termsConditionsSeeder.seedTermsConditions();
        }
    }
}
