package com.example.__crud_subscription.controller;

import com.example.__crud_subscription.dto.SubscriptionDTO;
import com.example.__crud_subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@Slf4j

public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        log.info("Received request to create subscription");
        return ResponseEntity.ok(subscriptionService.createSubscription(subscriptionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable Integer id, @RequestBody SubscriptionDTO subscriptionDTO) {
        log.info("Received request to update subscription with ID: {}", id);
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, subscriptionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Integer id) {
        log.info("Received request to delete subscription with ID: {}", id);
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable Integer id) {
        log.info("Received request to fetch subscription with ID: {}", id);
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(id));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions() {
        log.info("Received request to fetch all subscriptions");
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }
}
