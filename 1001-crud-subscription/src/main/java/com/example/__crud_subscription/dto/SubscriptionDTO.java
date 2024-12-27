package com.example.__crud_subscription.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubscriptionDTO {

    @NotBlank(message = "Subscription type cannot be blank")
    @Size(max = 50, message = "Subscription type cannot exceed 50 characters")
    String subscriptionType;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary amount")
    BigDecimal price;

    @NotNull(message = "Total stylist ads cannot be null")
    @Min(value = 0, message = "Total stylist ads must be zero or greater")
    Integer totalStylistAds;

    @NotNull(message = "Total salon ads cannot be null")
    @Min(value = 0, message = "Total salon ads must be zero or greater")
    Integer totalSalonAds;

    @NotNull(message = "Duration cannot be null")
    @Min(value = 1, message = "Duration must be at least 1 day")
    Integer duration;

    @FutureOrPresent(message = "Salon ads expiration date must be in the future or present")
    Instant salonAdsExpiration;

    @FutureOrPresent(message = "Stylist ads expiration date must be in the future or present")
    Instant stylistAdsExpiration;

    @NotBlank(message = "Banner cannot be blank")
    String banner;

    @Size(max = 100, message = "The subscription user list size must not exceed 100")
    List<SubscriptionUserDTO> subscriptionUsers;
}
