package com.example.__crud_subscription.mapper;


import com.example.__crud_subscription.dto.SubscriptionDTO;
import com.example.__crud_subscription.model.Subscription;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    SubscriptionDTO toDTO(Subscription subscription);

    Subscription toEntity(SubscriptionDTO subscriptionDTO);

}
