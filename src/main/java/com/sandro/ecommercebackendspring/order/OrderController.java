package com.sandro.ecommercebackendspring.order;

import com.sandro.ecommercebackendspring.order.dto.OrderRequestDTO;
import com.sandro.ecommercebackendspring.order.dto.OrderResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
        try {
            orderService.createOrder(orderRequest);
            return ResponseEntity.ok("Order placed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<Map<String, List<OrderResponseDTO>>> getOrders() {
        List<OrderResponseDTO> orders = orderService.getOrders();
        return ResponseEntity.ok(Map.of("orders", orders));
    }
}
