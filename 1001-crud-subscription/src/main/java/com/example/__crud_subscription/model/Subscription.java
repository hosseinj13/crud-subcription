package com.example.__crud_subscription.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subscription")
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "subscription_type")
    String subscriptionType;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "total_stylist_ads")
     Integer totalStylistAds;

    @Column(name = "total_salon_ads")
    Integer totalSalonAds;

    @Column(name = "duration")
     Integer duration;

    @Column(name = "salon_ads_expiration")
    Instant salonAdsExpiration;

    @Column(name = "stylist_ads_expiration")
    Instant stylistAdsExpiration;

    @Column(columnDefinition = "BIT")
    Boolean banner;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    List<SubscriptionUser> subscriptionUsers;
}