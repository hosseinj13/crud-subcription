package com.example.__crud_subscription.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionUserDTO {

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be a positive value")
    Long userId;

    @NotNull(message = "Subscription ID cannot be null")
    @Positive(message = "Subscription ID must be a positive value")
    Long subscriptionId;
}
