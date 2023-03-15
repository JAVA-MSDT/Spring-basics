package com.rest.serviceapi.service;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;

import java.util.Collections;
import java.util.List;

public interface ServiceService {
    List<SubscriptionResponseDto> getAllSubscription();

    SubscriptionResponseDto getSubscription(Long subscriptionId);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long subscriptionId);

}
