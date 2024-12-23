package com.example.__crud_subscription.service;

import com.example.__crud_subscription.dto.SubscriptionDTO;
import com.example.__crud_subscription.mapper.SubscriptionMapper;
import com.example.__crud_subscription.model.Subscription;
import com.example.__crud_subscription.repository.SubscriptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service

public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Transactional
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        log.info("Creating a new subscription: {}", subscriptionDTO);
        Subscription subscription = SubscriptionMapper.INSTANCE.toEntity(subscriptionDTO);
        if (subscription.getSubscriptionUsers() != null) {
            subscription.getSubscriptionUsers().forEach(subscriptionUser -> subscriptionUser.setSubscription(subscription));
        }
        return SubscriptionMapper.INSTANCE.toDTO(subscriptionRepository.save(subscription));
    }

    @Transactional
    public SubscriptionDTO updateSubscription(Integer id, SubscriptionDTO subscriptionDTO) {
        log.info("Updating subscription with ID: {}", id);
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found with id: " + id));
        subscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
        subscription.setPrice(subscriptionDTO.getPrice());
        subscription.setTotalStylistAds(subscriptionDTO.getTotalStylistAds());
        subscription.setTotalSalonAds(subscriptionDTO.getTotalSalonAds());
        subscription.setDuration(subscriptionDTO.getDuration());
        subscription.setSalonAdsExpiration(subscriptionDTO.getSalonAdsExpiration());
        subscription.setStylistAdsExpiration(subscriptionDTO.getStylistAdsExpiration());
      //  subscription.setBanner(subscriptionDTO.getBanner());
        return SubscriptionMapper.INSTANCE.toDTO(subscriptionRepository.save(subscription));
    }

    @Transactional
    public void deleteSubscription(Integer id) {
        log.info("Deleting subscription with ID: {}", id);
        subscriptionRepository.deleteById(id);
    }

    public SubscriptionDTO getSubscriptionById(Integer id) {
        log.info("Fetching subscription with ID: {}", id);
        return subscriptionRepository.findById(id)
                .map(SubscriptionMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found with id: " + id));
    }

    public List<SubscriptionDTO> getAllSubscriptions() {
        log.info("Fetching all subscriptions");
        return subscriptionRepository.findAll().stream()
                .map(SubscriptionMapper.INSTANCE::toDTO)
                .toList();
    }
}
