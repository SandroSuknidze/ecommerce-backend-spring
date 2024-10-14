package com.sandro.ecommercebackendspring.seeder;


import com.sandro.ecommercebackendspring.brand.BrandRepository;
import com.sandro.ecommercebackendspring.category.CategoryRepository;
import com.sandro.ecommercebackendspring.color.ColorRepository;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.product.ProductRepository;
import com.sandro.ecommercebackendspring.size.SizeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProductSeeder {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;

    @PostConstruct
    public void seedProducts() {
        if (productRepository.count() == 0) {

// Product 1
            Product product1 = new Product();
            product1.setTitle("Red Silk Blouse");
            product1.setDescription("Elegant red blouse made of high-quality silk.");
            product1.setPrice(BigDecimal.valueOf(150));
            product1.setSalePrice(BigDecimal.valueOf(120));
            product1.setStockQuantity(30);
            product1.setRating(4.5F);
            product1.setFeatured(true);
            product1.setCategory(categoryRepository.findByName("Womens Shirts").orElseThrow());
            product1.setBrand(brandRepository.findByName("Adrianna Papell").orElseThrow());
            product1.setImagePath(Arrays.asList("uploads/products/product1-1.webp", "uploads/products/product1-2.webp", "uploads/products/product1-3.webp", "uploads/products/product1-4.webp"));
            product1.setColors(Set.of(colorRepository.findByName("Red").orElseThrow(), colorRepository.findByName("White").orElseThrow()));
            product1.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product1);

// Product 2
            Product product2 = new Product();
            product2.setTitle("Winter Coat with Fur");
            product2.setDescription("Warm and stylish winter coat with detachable fur.");
            product2.setPrice(BigDecimal.valueOf(180));
            product2.setSalePrice(BigDecimal.valueOf(160));
            product2.setStockQuantity(50);
            product2.setRating(4.7F);
            product2.setFeatured(true);
            product2.setCategory(categoryRepository.findByName("Winter Coat").orElseThrow());
            product2.setBrand(brandRepository.findByName("Bally").orElseThrow());
            product2.setImagePath(Arrays.asList("uploads/products/product2-1.webp", "uploads/products/product2-2.webp"));
            product2.setColors(Set.of(colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Gray").orElseThrow()));
            product2.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow(), sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product2);

// Product 3
            Product product3 = new Product();
            product3.setTitle("Blue Sports Jacket");
            product3.setDescription("Lightweight jacket perfect for outdoor activities.");
            product3.setPrice(BigDecimal.valueOf(90));
            product3.setSalePrice(null);
            product3.setStockQuantity(75);
            product3.setRating(4.1F);
            product3.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product3.setBrand(brandRepository.findByName("C.P. Company").orElseThrow());
            product3.setImagePath(Arrays.asList("uploads/products/product3-1.webp", "uploads/products/product3-2.webp", "uploads/products/product3-3.webp"));
            product3.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Black").orElseThrow()));
            product3.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product3);

// Product 4
            Product product4 = new Product();
            product4.setTitle("Casual White Dress");
            product4.setDescription("Simple and elegant white dress for casual outings.");
            product4.setPrice(BigDecimal.valueOf(120));
            product4.setSalePrice(BigDecimal.valueOf(100));
            product4.setStockQuantity(40);
            product4.setRating(4.3F);
            product4.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product4.setBrand(brandRepository.findByName("Alberta Ferretti").orElseThrow());
            product4.setImagePath(Arrays.asList("uploads/products/product4-1.webp", "uploads/products/product4-2.webp"));
            product4.setColors(Set.of(colorRepository.findByName("White").orElseThrow(), colorRepository.findByName("Pink").orElseThrow()));
            product4.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product4);

// Product 5
            Product product5 = new Product();
            product5.setTitle("Orange T-Shirt");
            product5.setDescription("Bright orange T-shirt with a comfortable fit.");
            product5.setPrice(BigDecimal.valueOf(40));
            product5.setSalePrice(null);
            product5.setStockQuantity(60);
            product5.setRating(3.9F);
            product5.setCategory(categoryRepository.findByName("Top T-Shirt").orElseThrow());
            product5.setBrand(brandRepository.findByName("Aglini").orElseThrow());
            product5.setImagePath(Arrays.asList("uploads/products/product5-1.webp", "uploads/products/product5-2.webp", "uploads/products/product5-3.webp"));
            product5.setColors(Set.of(colorRepository.findByName("Orange").orElseThrow(), colorRepository.findByName("Pink").orElseThrow(), colorRepository.findByName("Red").orElseThrow()));
            product5.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product5);

// Product 6
            Product product6 = new Product();
            product6.setTitle("Cozy Winter Sweater");
            product6.setDescription("Warm and soft sweater perfect for cold weather.");
            product6.setPrice(BigDecimal.valueOf(80));
            product6.setSalePrice(BigDecimal.valueOf(65));
            product6.setStockQuantity(90);
            product6.setRating(4.6F);
            product6.setCategory(categoryRepository.findByName("Sweaters").orElseThrow());
            product6.setBrand(brandRepository.findByName("Baxton Studio").orElseThrow());
            product6.setImagePath(Arrays.asList("uploads/products/product6-1.webp", "uploads/products/product6-2.webp"));
            product6.setColors(Set.of(colorRepository.findByName("Brown").orElseThrow(), colorRepository.findByName("Gray").orElseThrow(), colorRepository.findByName("Pink").orElseThrow()));
            product6.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product6);

// Product 7
            Product product7 = new Product();
            product7.setTitle("Denim Shirt");
            product7.setDescription("Classic denim shirt for a casual yet fashionable look.");
            product7.setPrice(BigDecimal.valueOf(70));
            product7.setSalePrice(null);
            product7.setStockQuantity(30);
            product7.setRating(4.2F);
            product7.setCategory(categoryRepository.findByName("Denim Shirt").orElseThrow());
            product7.setBrand(brandRepository.findByName("Cafènoir").orElseThrow());
            product7.setImagePath(Arrays.asList("uploads/products/product7-1.webp", "uploads/products/product7-2.webp", "uploads/products/product7-3.webp"));
            product7.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Purple").orElseThrow()));
            product7.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product7);

// Product 8
            Product product8 = new Product();
            product8.setTitle("Pink Silk Dress");
            product8.setDescription("Soft and luxurious pink silk dress for formal events.");
            product8.setPrice(BigDecimal.valueOf(200));
            product8.setSalePrice(BigDecimal.valueOf(180));
            product8.setStockQuantity(20);
            product8.setRating(4.8F);
            product8.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product8.setBrand(brandRepository.findByName("BaubleBar").orElseThrow());
            product8.setImagePath(Arrays.asList("uploads/products/product8-1.webp", "uploads/products/product8-2.webp", "uploads/products/product8-3.webp"));
            product8.setColors(Set.of(colorRepository.findByName("Pink").orElseThrow(), colorRepository.findByName("White").orElseThrow(), colorRepository.findByName("Purple").orElseThrow()));
            product8.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product8);

// Product 9
            Product product9 = new Product();
            product9.setTitle("Athletic Sports Jacket");
            product9.setDescription("Lightweight sports jacket for active individuals.");
            product9.setPrice(BigDecimal.valueOf(85));
            product9.setSalePrice(null);
            product9.setStockQuantity(65);
            product9.setRating(4.0F);
            product9.setFeatured(true);
            product9.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product9.setBrand(brandRepository.findByName("C.P. Company").orElseThrow());
            product9.setImagePath(Arrays.asList("uploads/products/product9-1.webp", "uploads/products/product9-2.webp", "uploads/products/product9-3.webp"));
            product9.setColors(Set.of(colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Purple").orElseThrow(), colorRepository.findByName("Orange").orElseThrow()));
            product9.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product9);

// Product 10
            Product product10 = new Product();
            product10.setTitle("Casual Denim Overalls");
            product10.setDescription("Comfortable denim overalls for a casual day out.");
            product10.setPrice(BigDecimal.valueOf(110));
            product10.setSalePrice(BigDecimal.valueOf(90));
            product10.setStockQuantity(45);
            product10.setRating(4.4F);
            product10.setFeatured(true);
            product10.setCategory(categoryRepository.findByName("Overalls").orElseThrow());
            product10.setBrand(brandRepository.findByName("Certified International").orElseThrow());
            product10.setImagePath(Arrays.asList("uploads/products/product10-1.webp", "uploads/products/product10-2.webp", "uploads/products/product10-3.webp"));
            product10.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Black").orElseThrow()));
            product10.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product10);


// Product 11
            Product product11 = new Product();
            product11.setTitle("Elegant Black Gown");
            product11.setDescription("A luxurious black gown for special occasions.");
            product11.setPrice(BigDecimal.valueOf(190));
            product11.setSalePrice(BigDecimal.valueOf(170));
            product11.setStockQuantity(25);
            product11.setRating(4.9F);
            product11.setFeatured(true);
            product11.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product11.setBrand(brandRepository.findByName("Umino").orElseThrow());
            product11.setImagePath(Arrays.asList("uploads/products/product11-1.webp", "uploads/products/product11-2.webp", "uploads/products/product11-3.webp", "uploads/products/product11-4.webp", "uploads/products/product11-5.webp"));
            product11.setColors(Set.of(colorRepository.findByName("Black").orElseThrow()));
            product11.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product11);

// Product 12
            Product product12 = new Product();
            product12.setTitle("Brown Overalls");
            product12.setDescription("Stylish brown overalls made of soft denim.");
            product12.setPrice(BigDecimal.valueOf(95));
            product12.setSalePrice(null);
            product12.setStockQuantity(35);
            product12.setRating(4.3F);
            product12.setFeatured(true);
            product12.setCategory(categoryRepository.findByName("Overalls").orElseThrow());
            product12.setBrand(brandRepository.findByName("Casadei").orElseThrow());
            product12.setImagePath(Arrays.asList("uploads/products/product12-1.webp", "uploads/products/product12-2.webp", "uploads/products/product12-3.webp", "uploads/products/product12-4.webp", "uploads/products/product12-5.webp"));
            product12.setColors(Set.of(colorRepository.findByName("Brown").orElseThrow()));
            product12.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow(), sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product12);

// Product 13
            Product product13 = new Product();
            product13.setTitle("White Silk Blouse");
            product13.setDescription("Chic white blouse, perfect for formal events.");
            product13.setPrice(BigDecimal.valueOf(130));
            product13.setSalePrice(BigDecimal.valueOf(115));
            product13.setStockQuantity(22);
            product13.setRating(4.2F);
            product13.setFeatured(true);
            product13.setCategory(categoryRepository.findByName("Womens Shirts").orElseThrow());
            product13.setBrand(brandRepository.findByName("Bcbgmaxazria").orElseThrow());
            product13.setImagePath(Arrays.asList("uploads/products/product13-1.webp", "uploads/products/product13-2.webp", "uploads/products/product13-3.webp", "uploads/products/product13-4.webp", "uploads/products/product13-5.webp"));
            product13.setColors(Set.of(colorRepository.findByName("White").orElseThrow()));
            product13.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product13);

// Product 14
            Product product14 = new Product();
            product14.setTitle("Sporty Green Hoodie");
            product14.setDescription("Comfortable green hoodie for sports and leisure.");
            product14.setPrice(BigDecimal.valueOf(80));
            product14.setSalePrice(BigDecimal.valueOf(70));
            product14.setStockQuantity(60);
            product14.setRating(4.6F);
            product14.setFeatured(true);
            product14.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product14.setBrand(brandRepository.findByName("Bally").orElseThrow());
            product14.setImagePath(Arrays.asList("uploads/products/product14-1.webp", "uploads/products/product14-2.webp", "uploads/products/product14-3.webp"));
            product14.setColors(Set.of(colorRepository.findByName("Green").orElseThrow(), colorRepository.findByName("Purple").orElseThrow(), colorRepository.findByName("Orange").orElseThrow()));
            product14.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product14);

// Product 15
            Product product15 = new Product();
            product15.setTitle("Yellow Top T-Shirt");
            product15.setDescription("Bright yellow t-shirt with a fun design.");
            product15.setPrice(BigDecimal.valueOf(45));
            product15.setSalePrice(null);
            product15.setStockQuantity(50);
            product15.setRating(3.8F);
            product15.setFeatured(true);
            product15.setCategory(categoryRepository.findByName("Top T-Shirt").orElseThrow());
            product15.setBrand(brandRepository.findByName("Aglini").orElseThrow());
            product15.setImagePath(Arrays.asList("uploads/products/product15-1.webp", "uploads/products/product15-2.webp", "uploads/products/product15-3.webp"));
            product15.setColors(Set.of(colorRepository.findByName("Yellow").orElseThrow()));
            product15.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product15);

// Product 16
            Product product16 = new Product();
            product16.setTitle("Cozy Black Sweater");
            product16.setDescription("Soft and warm black sweater for winter.");
            product16.setPrice(BigDecimal.valueOf(85));
            product16.setSalePrice(BigDecimal.valueOf(75));
            product16.setStockQuantity(40);
            product16.setRating(4.7F);
            product16.setFeatured(true);
            product16.setCategory(categoryRepository.findByName("Sweaters").orElseThrow());
            product16.setBrand(brandRepository.findByName("Baxton Studio").orElseThrow());
            product16.setImagePath(Arrays.asList("uploads/products/product16-1.webp", "uploads/products/product16-2.webp", "uploads/products/product16-3.webp"));
            product16.setColors(Set.of(colorRepository.findByName("Black").orElseThrow()));
            product16.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product16);

// Product 17
            Product product17 = new Product();
            product17.setTitle("Pink Denim Shirt");
            product17.setDescription("Stylish denim shirt in a soft pink shade.");
            product17.setPrice(BigDecimal.valueOf(70));
            product17.setSalePrice(null);
            product17.setStockQuantity(32);
            product17.setRating(4.1F);
            product17.setCategory(categoryRepository.findByName("Denim Shirt").orElseThrow());
            product17.setBrand(brandRepository.findByName("Cafènoir").orElseThrow());
            product17.setImagePath(Arrays.asList("uploads/products/product17-1.webp", "uploads/products/product17-2.webp", "uploads/products/product17-3.webp"));
            product17.setColors(Set.of(colorRepository.findByName("Pink").orElseThrow()));
            product17.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product17);

// Product 18
            Product product18 = new Product();
            product18.setTitle("Elegant White Gown");
            product18.setDescription("A luxurious white gown, ideal for formal events.");
            product18.setPrice(BigDecimal.valueOf(175));
            product18.setSalePrice(BigDecimal.valueOf(160));
            product18.setStockQuantity(30);
            product18.setRating(4.8F);
            product18.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product18.setBrand(brandRepository.findByName("Umino").orElseThrow());
            product18.setImagePath(Arrays.asList("uploads/products/product18-1.webp", "uploads/products/product18-2.webp", "uploads/products/product18-3.webp"));
            product18.setColors(Set.of(colorRepository.findByName("White").orElseThrow()));
            product18.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product18);

// Product 19
            Product product19 = new Product();
            product19.setTitle("Casual Blue Hoodie");
            product19.setDescription("Relaxed-fit hoodie for everyday wear.");
            product19.setPrice(BigDecimal.valueOf(75));
            product19.setSalePrice(null);
            product19.setStockQuantity(55);
            product19.setRating(4.5F);
            product19.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product19.setBrand(brandRepository.findByName("C.P. Company").orElseThrow());
            product19.setImagePath(Arrays.asList("uploads/products/product19-1.webp", "uploads/products/product19-2.webp", "uploads/products/product19-3.webp"));
            product19.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Red").orElseThrow(), colorRepository.findByName("Gray").orElseThrow()));
            product19.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product19);

// Product 20
            Product product20 = new Product();
            product20.setTitle("Chic Red Blouse");
            product20.setDescription("A vibrant red blouse with a sleek design.");
            product20.setPrice(BigDecimal.valueOf(95));
            product20.setSalePrice(BigDecimal.valueOf(85));
            product20.setStockQuantity(40);
            product20.setRating(4.7F);
            product20.setCategory(categoryRepository.findByName("Womens Shirts").orElseThrow());
            product20.setBrand(brandRepository.findByName("Adrianna Papell").orElseThrow());
            product20.setImagePath(Arrays.asList("uploads/products/product20-1.webp", "uploads/products/product20-2.webp", "uploads/products/product20-3.webp"));
            product20.setColors(Set.of(colorRepository.findByName("Red").orElseThrow()));
            product20.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product20);

// Product 21
            Product product21 = new Product();
            product21.setTitle("Yellow Overalls");
            product21.setDescription("Bright and fun yellow overalls for casual wear.");
            product21.setPrice(BigDecimal.valueOf(80));
            product21.setSalePrice(BigDecimal.valueOf(70));
            product21.setStockQuantity(28);
            product21.setRating(4.1F);
            product21.setFeatured(true);
            product21.setCategory(categoryRepository.findByName("Overalls").orElseThrow());
            product21.setBrand(brandRepository.findByName("Certified International").orElseThrow());
            product21.setImagePath(Arrays.asList("uploads/products/product21-1.webp", "uploads/products/product21-2.webp", "uploads/products/product21-3.webp", "uploads/products/product21-4.webp", "uploads/products/product21-5.webp"));
            product21.setColors(Set.of(colorRepository.findByName("Yellow").orElseThrow(), colorRepository.findByName("Purple").orElseThrow(), colorRepository.findByName("Red").orElseThrow()));
            product21.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow(), sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product21);

// Product 22
            Product product22 = new Product();
            product22.setTitle("Purple Dress");
            product22.setDescription("Elegant purple dress, perfect for evening wear.");
            product22.setPrice(BigDecimal.valueOf(120));
            product22.setSalePrice(BigDecimal.valueOf(100));
            product22.setStockQuantity(20);
            product22.setRating(4.9F);
            product22.setFeatured(true);
            product22.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product22.setBrand(brandRepository.findByName("Alberta Ferretti").orElseThrow());
            product22.setImagePath(Arrays.asList("uploads/products/product22-1.webp", "uploads/products/product22-2.webp", "uploads/products/product22-3.webp", "uploads/products/product22-4.webp"));
            product22.setColors(Set.of(colorRepository.findByName("Purple").orElseThrow(), colorRepository.findByName("Green").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow()));
            product22.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product22);

// Product 23
            Product product23 = new Product();
            product23.setTitle("Gray Turtleneck Sweater");
            product23.setDescription("Cozy turtleneck sweater for the winter season.");
            product23.setPrice(BigDecimal.valueOf(70));
            product23.setSalePrice(null);
            product23.setStockQuantity(40);
            product23.setRating(4.6F);
            product23.setCategory(categoryRepository.findByName("Sweaters").orElseThrow());
            product23.setBrand(brandRepository.findByName("BaubleBar").orElseThrow());
            product23.setImagePath(Arrays.asList("uploads/products/product23-1.webp", "uploads/products/product23-2.webp", "uploads/products/product23-3.webp", "uploads/products/product23-4.webp"));
            product23.setColors(Set.of(colorRepository.findByName("Gray").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow(), colorRepository.findByName("Red").orElseThrow()));
            product23.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product23);

// Product 24
            Product product24 = new Product();
            product24.setTitle("Stylish Denim Shirt");
            product24.setDescription("Trendy denim shirt, versatile for all seasons.");
            product24.setPrice(BigDecimal.valueOf(85));
            product24.setSalePrice(BigDecimal.valueOf(75));
            product24.setStockQuantity(30);
            product24.setRating(4.3F);
            product24.setFeatured(true);
            product24.setCategory(categoryRepository.findByName("Denim Shirt").orElseThrow());
            product24.setBrand(brandRepository.findByName("AG - Adriano").orElseThrow());
            product24.setImagePath(Arrays.asList("uploads/products/product24-1.webp", "uploads/products/product24-2.webp", "uploads/products/product24-3.webp", "uploads/products/product24-4.webp"));
            product24.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow()));
            product24.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product24);

// Product 25
            Product product25 = new Product();
            product25.setTitle("White Underwear Set");
            product25.setDescription("Comfortable and soft underwear set.");
            product25.setPrice(BigDecimal.valueOf(40));
            product25.setSalePrice(BigDecimal.valueOf(35));
            product25.setStockQuantity(50);
            product25.setRating(4.5F);
            product25.setCategory(categoryRepository.findByName("Underwear").orElseThrow());
            product25.setBrand(brandRepository.findByName("C.P. Company").orElseThrow());
            product25.setImagePath(Arrays.asList("uploads/products/product25-1.webp", "uploads/products/product25-2.webp", "uploads/products/product25-3.webp"));
            product25.setColors(Set.of(colorRepository.findByName("White").orElseThrow(), colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow()));
            product25.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product25);

            // Product 26
            Product product26 = new Product();
            product26.setTitle("Floral Maxi Dress");
            product26.setDescription("Beautiful floral maxi dress for sunny days.");
            product26.setPrice(BigDecimal.valueOf(110));
            product26.setSalePrice(BigDecimal.valueOf(90));
            product26.setStockQuantity(15);
            product26.setRating(4.8F);
            product26.setFeatured(true);
            product26.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product26.setBrand(brandRepository.findByName("Aglini").orElseThrow());
            product26.setImagePath(Arrays.asList("uploads/products/product26-1.webp", "uploads/products/product26-2.webp", "uploads/products/product26-3.webp"));
            product26.setColors(Set.of(colorRepository.findByName("Pink").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow(), colorRepository.findByName("Orange").orElseThrow()));
            product26.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow(), sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product26);

// Product 27
            Product product27 = new Product();
            product27.setTitle("Casual White T-Shirt");
            product27.setDescription("Simple yet stylish white T-shirt for everyday use.");
            product27.setPrice(BigDecimal.valueOf(30));
            product27.setSalePrice(null);
            product27.setStockQuantity(100);
            product27.setRating(4.4F);
            product27.setCategory(categoryRepository.findByName("Top T-Shirt").orElseThrow());
            product27.setBrand(brandRepository.findByName("Bcbgmaxazria").orElseThrow());
            product27.setImagePath(Arrays.asList("uploads/products/product27-1.webp", "uploads/products/product27-2.webp", "uploads/products/product27-3.webp"));
            product27.setColors(Set.of(colorRepository.findByName("White").orElseThrow()));
            product27.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product27);

// Product 28
            Product product28 = new Product();
            product28.setTitle("Sleek Black Skirt");
            product28.setDescription("Stylish black skirt for formal occasions.");
            product28.setPrice(BigDecimal.valueOf(85));
            product28.setSalePrice(BigDecimal.valueOf(70));
            product28.setStockQuantity(25);
            product28.setRating(4.7F);
            product28.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product28.setBrand(brandRepository.findByName("Alberta Ferretti").orElseThrow());
            product28.setImagePath(Arrays.asList("uploads/products/product28-1.webp", "uploads/products/product28-2.webp"));
            product28.setColors(Set.of(colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Brown").orElseThrow(), colorRepository.findByName("Blue").orElseThrow()));
            product28.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product28);

// Product 29
            Product product29 = new Product();
            product29.setTitle("Cozy Beige Sweater");
            product29.setDescription("Warm and soft beige sweater for chilly days.");
            product29.setPrice(BigDecimal.valueOf(70));
            product29.setSalePrice(null);
            product29.setStockQuantity(50);
            product29.setRating(4.5F);
            product29.setFeatured(true);
            product29.setCategory(categoryRepository.findByName("Sweaters").orElseThrow());
            product29.setBrand(brandRepository.findByName("Bally").orElseThrow());
            product29.setImagePath(Arrays.asList("uploads/products/product29-1.webp", "uploads/products/product29-2.webp", "uploads/products/product29-3.webp", "uploads/products/product29-4.webp"));
            product29.setColors(Set.of(colorRepository.findByName("Brown").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow(), colorRepository.findByName("Pink").orElseThrow()));
            product29.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product29);

// Product 30
            Product product30 = new Product();
            product30.setTitle("Elegant Black Dress");
            product30.setDescription("Sleek black dress perfect for evening events.");
            product30.setPrice(BigDecimal.valueOf(150));
            product30.setSalePrice(BigDecimal.valueOf(130));
            product30.setStockQuantity(12);
            product30.setRating(4.9F);
            product30.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product30.setBrand(brandRepository.findByName("Umino").orElseThrow());
            product30.setImagePath(Arrays.asList("uploads/products/product30-1.webp", "uploads/products/product30-2.webp", "uploads/products/product30-3.webp", "uploads/products/product30-4.webp"));
            product30.setColors(Set.of(colorRepository.findByName("Black").orElseThrow()));
            product30.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product30);

            // Product 31
            Product product31 = new Product();
            product31.setTitle("Stylish Denim Jacket");
            product31.setDescription("Trendy denim jacket for casual outings.");
            product31.setPrice(BigDecimal.valueOf(80));
            product31.setSalePrice(null);
            product31.setStockQuantity(40);
            product31.setRating(4.6F);
            product31.setCategory(categoryRepository.findByName("Denim Shirt").orElseThrow());
            product31.setBrand(brandRepository.findByName("C.P. Company").orElseThrow());
            product31.setImagePath(Arrays.asList("uploads/products/product31-2.webp", "uploads/products/product31-1.webp", "uploads/products/product31-3.webp"));
            product31.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow(), colorRepository.findByName("Red").orElseThrow()));
            product31.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product31);

// Product 32
            Product product32 = new Product();
            product32.setTitle("Chic Black Jumpsuit");
            product32.setDescription("Elegant black jumpsuit for a sophisticated look.");
            product32.setPrice(BigDecimal.valueOf(120));
            product32.setSalePrice(null);
            product32.setStockQuantity(30);
            product32.setRating(4.7F);
            product32.setCategory(categoryRepository.findByName("Overalls").orElseThrow());
            product32.setBrand(brandRepository.findByName("AG - Adriano").orElseThrow());
            product32.setImagePath(Arrays.asList("uploads/products/product32-1.webp", "uploads/products/product32-2.webp", "uploads/products/product32-3.webp", "uploads/products/product32-4.webp"));
            product32.setColors(Set.of(colorRepository.findByName("Black").orElseThrow()));
            product32.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product32);

// Product 33
            Product product33 = new Product();
            product33.setTitle("Warm Winter Coat");
            product33.setDescription("Cozy coat for cold winter days.");
            product33.setPrice(BigDecimal.valueOf(200));
            product33.setSalePrice(BigDecimal.valueOf(180));
            product33.setStockQuantity(10);
            product33.setRating(4.5F);
            product33.setCategory(categoryRepository.findByName("Winter Coat").orElseThrow());
            product33.setBrand(brandRepository.findByName("Bcbgmaxazria").orElseThrow());
            product33.setImagePath(Arrays.asList("uploads/products/product33-1.webp", "uploads/products/product33-2.webp", "uploads/products/product33-3.webp", "uploads/products/product33-4.webp"));
            product33.setColors(Set.of(colorRepository.findByName("Gray").orElseThrow(), colorRepository.findByName("Green").orElseThrow(), colorRepository.findByName("Yellow").orElseThrow()));
            product33.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product33);

// Product 34
            Product product34 = new Product();
            product34.setTitle("Sporty Jogger Pants");
            product34.setDescription("Comfortable jogger pants for workouts.");
            product34.setPrice(BigDecimal.valueOf(50));
            product34.setSalePrice(null);
            product34.setStockQuantity(20);
            product34.setRating(4.3F);
            product34.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product34.setBrand(brandRepository.findByName("Casadei").orElseThrow());
            product34.setImagePath(Arrays.asList("uploads/products/product34-1.webp", "uploads/products/product34-2.webp", "uploads/products/product34-3.webp"));
            product34.setColors(Set.of(colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Gray").orElseThrow()));
            product34.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product34);

// Product 35
            Product product35 = new Product();
            product35.setTitle("Graphic Tee");
            product35.setDescription("Trendy graphic tee for casual wear.");
            product35.setPrice(BigDecimal.valueOf(25));
            product35.setSalePrice(null);
            product35.setStockQuantity(150);
            product35.setRating(4.1F);
            product35.setCategory(categoryRepository.findByName("Top T-Shirt").orElseThrow());
            product35.setBrand(brandRepository.findByName("BaubleBar").orElseThrow());
            product35.setImagePath(Arrays.asList("uploads/products/product35-1.webp", "uploads/products/product35-2.webp", "uploads/products/product35-3.webp", "uploads/products/product35-4.webp"));
            product35.setColors(Set.of(colorRepository.findByName("Red").orElseThrow(), colorRepository.findByName("Orange").orElseThrow(), colorRepository.findByName("Pink").orElseThrow()));
            product35.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product35);

// Product 36
            Product product36 = new Product();
            product36.setTitle("Knitted Sweater");
            product36.setDescription("Warm knitted sweater perfect for layering.");
            product36.setPrice(BigDecimal.valueOf(70));
            product36.setSalePrice(null);
            product36.setStockQuantity(45);
            product36.setRating(4.4F);
            product36.setCategory(categoryRepository.findByName("Sweaters").orElseThrow());
            product36.setBrand(brandRepository.findByName("Adrianna Papell").orElseThrow());
            product36.setImagePath(Arrays.asList("uploads/products/product36-1.webp", "uploads/products/product36-2.webp"));
            product36.setColors(Set.of(colorRepository.findByName("Brown").orElseThrow(), colorRepository.findByName("Orange").orElseThrow()));
            product36.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product36);

// Product 37
            Product product37 = new Product();
            product37.setTitle("Striped T-Shirt");
            product37.setDescription("Classic striped T-shirt for a casual look.");
            product37.setPrice(BigDecimal.valueOf(35));
            product37.setSalePrice(null);
            product37.setStockQuantity(60);
            product37.setRating(4.2F);
            product37.setCategory(categoryRepository.findByName("Top T-Shirt").orElseThrow());
            product37.setBrand(brandRepository.findByName("Bally").orElseThrow());
            product37.setImagePath(Arrays.asList("uploads/products/product37-1.webp", "uploads/products/product37-2.webp", "uploads/products/product37-3.webp", "uploads/products/product37-4.webp"));
            product37.setColors(Set.of(colorRepository.findByName("White").orElseThrow(), colorRepository.findByName("Black").orElseThrow()));
            product37.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product37);

// Product 38
            Product product38 = new Product();
            product38.setTitle("Elegant Wrap Dress");
            product38.setDescription("Stylish wrap dress for any occasion.");
            product38.setPrice(BigDecimal.valueOf(100));
            product38.setSalePrice(BigDecimal.valueOf(85));
            product38.setStockQuantity(20);
            product38.setRating(4.6F);
            product38.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product38.setBrand(brandRepository.findByName("Aglini").orElseThrow());
            product38.setImagePath(Arrays.asList("uploads/products/product38-1.webp", "uploads/products/product38-2.webp", "uploads/products/product38-3.webp"));
            product38.setColors(Set.of(colorRepository.findByName("Red").orElseThrow(), colorRepository.findByName("Orange").orElseThrow(), colorRepository.findByName("Black").orElseThrow()));
            product38.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product38);

// Product 39
            Product product39 = new Product();
            product39.setTitle("Lightweight Summer Jacket");
            product39.setDescription("Perfect jacket for cool summer evenings.");
            product39.setPrice(BigDecimal.valueOf(90));
            product39.setSalePrice(null);
            product39.setStockQuantity(35);
            product39.setRating(4.5F);
            product39.setCategory(categoryRepository.findByName("Winter Coat").orElseThrow());
            product39.setBrand(brandRepository.findByName("Umino").orElseThrow());
            product39.setImagePath(Arrays.asList("uploads/products/product39-1.webp", "uploads/products/product39-2.webp", "uploads/products/product39-3.webp"));
            product39.setColors(Set.of(colorRepository.findByName("Blue").orElseThrow()));
            product39.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product39);

// Product 40
            Product product40 = new Product();
            product40.setTitle("Fitted Blazer");
            product40.setDescription("Tailored blazer for a professional look.");
            product40.setPrice(BigDecimal.valueOf(150));
            product40.setSalePrice(BigDecimal.valueOf(130));
            product40.setStockQuantity(15);
            product40.setRating(4.8F);
            product40.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product40.setBrand(brandRepository.findByName("AG - Adriano").orElseThrow());
            product40.setImagePath(Arrays.asList("uploads/products/product40-1.webp", "uploads/products/product40-2.webp"));
            product40.setColors(Set.of(colorRepository.findByName("Black").orElseThrow(), colorRepository.findByName("Red").orElseThrow(), colorRepository.findByName("Orange").orElseThrow()));
            product40.setSizes(Set.of(sizeRepository.findByName("L").orElseThrow(), sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product40);

// Product 41
            Product product41 = new Product();
            product41.setTitle("Casual Printed Dress");
            product41.setDescription("Comfortable printed dress for everyday wear.");
            product41.setPrice(BigDecimal.valueOf(65));
            product41.setSalePrice(null);
            product41.setStockQuantity(50);
            product41.setRating(4.3F);
            product41.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product41.setBrand(brandRepository.findByName("Baxton Studio").orElseThrow());
            product41.setImagePath(Arrays.asList("uploads/products/product41-1.webp", "uploads/products/product41-2.webp", "uploads/products/product41-3.webp", "uploads/products/product41-4.webp", "uploads/products/product41-5.webp"));
            product41.setColors(Set.of(colorRepository.findByName("Pink").orElseThrow(), colorRepository.findByName("White").orElseThrow()));
            product41.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product41);

// Product 42
            Product product42 = new Product();
            product42.setTitle("Trendy Wrap Skirt");
            product42.setDescription("Chic wrap skirt for a stylish outfit.");
            product42.setPrice(BigDecimal.valueOf(45));
            product42.setSalePrice(null);
            product42.setStockQuantity(25);
            product42.setRating(4.4F);
            product42.setFeatured(true);
            product42.setCategory(categoryRepository.findByName("Dresses").orElseThrow());
            product42.setBrand(brandRepository.findByName("Alberta Ferretti").orElseThrow());
            product42.setImagePath(Arrays.asList("uploads/products/product42-1.webp", "uploads/products/product42-2.webp"));
            product42.setColors(Set.of(colorRepository.findByName("Yellow").orElseThrow()));
            product42.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product42);

// Product 43
            Product product43 = new Product();
            product43.setTitle("Casual Cargo Pants");
            product43.setDescription("Comfortable cargo pants for a laid-back style.");
            product43.setPrice(BigDecimal.valueOf(60));
            product43.setSalePrice(null);
            product43.setStockQuantity(70);
            product43.setRating(4.2F);
            product43.setCategory(categoryRepository.findByName("Sportswear").orElseThrow());
            product43.setBrand(brandRepository.findByName("Baxton Studio").orElseThrow());
            product43.setImagePath(Arrays.asList("uploads/products/product43-1.webp", "uploads/products/product43-2.webp", "uploads/products/product43-3.webp", "uploads/products/product43-4.webp"));
            product43.setColors(Set.of(colorRepository.findByName("Green").orElseThrow(), colorRepository.findByName("Purple").orElseThrow(), colorRepository.findByName("Red").orElseThrow()));
            product43.setSizes(Set.of(sizeRepository.findByName("M").orElseThrow(), sizeRepository.findByName("L").orElseThrow()));
            productRepository.save(product43);

// Product 44
            Product product44 = new Product();
            product44.setTitle("Classic White Shirt");
            product44.setDescription("Essential white shirt for any wardrobe.");
            product44.setPrice(BigDecimal.valueOf(40));
            product44.setSalePrice(null);
            product44.setStockQuantity(100);
            product44.setRating(4.5F);
            product44.setFeatured(true);
            product44.setCategory(categoryRepository.findByName("Womens Shirts").orElseThrow());
            product44.setBrand(brandRepository.findByName("AG - Adriano").orElseThrow());
            product44.setImagePath(Arrays.asList("uploads/products/product44-1.webp", "uploads/products/product44-2.webp", "uploads/products/product44-3.webp", "uploads/products/product44-4.webp", "uploads/products/product44-5.webp"));
            product44.setColors(Set.of(colorRepository.findByName("White").orElseThrow(), colorRepository.findByName("Purple").orElseThrow()));
            product44.setSizes(Set.of(sizeRepository.findByName("S").orElseThrow(), sizeRepository.findByName("M").orElseThrow()));
            productRepository.save(product44);

// Product 45
            Product product45 = new Product();
            product45.setTitle("Stylish Plaid Scarf");
            product45.setDescription("Cozy plaid scarf for colder days.");
            product45.setPrice(BigDecimal.valueOf(25));
            product45.setSalePrice(null);
            product45.setStockQuantity(150);
            product45.setRating(4.9F);
            product45.setFeatured(true);
            product45.setCategory(categoryRepository.findByName("Winter Coat").orElseThrow());
            product45.setBrand(brandRepository.findByName("Bcbgmaxazria").orElseThrow());
            product45.setImagePath(Arrays.asList("uploads/products/product45-1.webp", "uploads/products/product45-2.webp", "uploads/products/product45-3.webp"));
            product45.setColors(Set.of(colorRepository.findByName("Gray").orElseThrow(), colorRepository.findByName("Orange").orElseThrow(), colorRepository.findByName("Purple").orElseThrow()));
            product45.setSizes(Set.of(sizeRepository.findByName("XL").orElseThrow()));
            productRepository.save(product45);

        }
    }
}
