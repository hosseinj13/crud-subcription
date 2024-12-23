package com.example.__crud_subscription.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subscription_user")
@Entity
public class SubscriptionUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    Subscription subscription;
//    @EmbeddedId
//    private SubscriptionUserId subscriptionUserId;
//
//    @Column(name = "stylist_advertisement_no")
//    private Integer stylistAdvertisementNo;
//
//    @Column(name = "salon_advertisement_no")
//    private Integer salonAdvertisementNO;
//
//    @Column(name = "created_at")
//    private Instant createdAt;
}
