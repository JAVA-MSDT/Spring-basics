package com.rest.serviceapi.service;

import java.util.List;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;

public interface SubscriptionService {

    List<SubscriptionResponseDto> getAllSubscription();

    SubscriptionResponseDto getSubscription(Long subscriptionId);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto);

    boolean deleteSubscription(Long subscriptionId);

}
