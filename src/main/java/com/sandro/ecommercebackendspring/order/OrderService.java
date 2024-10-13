package com.sandro.ecommercebackendspring.order;

import com.sandro.ecommercebackendspring.cart.Cart;
import com.sandro.ecommercebackendspring.cart.CartRepository;
import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.order.dto.*;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.product.ProductRepository;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void createOrder(OrderRequestDTO orderRequest) {
        User user = getCurrentUser();
        List<Cart> cartItems = cartRepository.findByUser(user);

        for (Cart cartItem : cartItems) {
            Product product = cartItem.getProduct();

            if (product.getStockQuantity() >= cartItem.getQuantity() && cartItem.getQuantity() > 0) {
                BigDecimal price = product.getSalePrice() != null ? product.getSalePrice() : product.getPrice();

                Order order = new Order();
                order.setUser(user);
                order.setProduct(product);
                order.setSize(cartItem.getSize());
                order.setColor(cartItem.getColor());
                order.setQuantity(cartItem.getQuantity());
                order.setTotalPrice(price.multiply(BigDecimal.valueOf(cartItem.getQuantity())));
                order.setNote(orderRequest.getData().getNote());
                order.setCountry(orderRequest.getData().getCountry());
                order.setCity(orderRequest.getData().getCity());
                order.setZipCode(orderRequest.getData().getZipCode());
                orderRepository.save(order);

//                It would be set for a real production
//                product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
//                productRepository.save(product);

                cartRepository.deleteByUserId(user.getId());
            } else {
                throw new RuntimeException("Insufficient stock for product: " + product.getTitle());
            }
        }
    }

    public List<OrderResponseDTO> getOrders() {
        User user = getCurrentUser();
        List<Order> orders = orderRepository.findByUser(user);

        return orders.stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
    }

    private OrderResponseDTO mapToOrderResponseDTO(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setProductId(order.getProduct().getId());
        dto.setSizeId(order.getSize().getId());
        dto.setColorId(order.getColor().getId());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setNote(order.getNote());
        dto.setCountry(order.getCountry());
        dto.setCity(order.getCity());
        dto.setZipCode(order.getZipCode());


        dto.setPurchasedAt(order.getCreatedAt().format(formatter));
        dto.setCreatedAt(order.getCreatedAt().format(formatter));

        dto.setProduct(mapToProductDTO(order.getProduct()));
        dto.setSize(mapToSizeDTO(order.getSize()));
        dto.setColor(mapToColorDTO(order.getColor()));

        return dto;
    }

    private ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setBrandId(product.getBrand().getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setImagePath(product.getImagePath());
        productDTO.setPrice(product.getPrice());
        productDTO.setSalePrice(product.getSalePrice());
        productDTO.setRating(product.getRating());
        productDTO.setStockQuantity(product.getStockQuantity());
        productDTO.setFeatured(product.isFeatured());
        productDTO.setCreatedAt(product.getCreatedAt().toString());

        return productDTO;
    }

    private SizeDTO mapToSizeDTO(Size size) {
        SizeDTO sizeDTO = new SizeDTO();
        sizeDTO.setId(size.getId());
        sizeDTO.setName(size.getName());

        return sizeDTO;
    }

    private ColorDTO mapToColorDTO(Color color) {
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setId(color.getId());
        colorDTO.setName(color.getName());
        colorDTO.setColorCode(color.getColor());

        return colorDTO;
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        } else {
            return user;
        }
    }
}
