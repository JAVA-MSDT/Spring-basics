package com.rest.cloudserviceimpl.service;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.serviceapi.service.SubscriptionService;

import java.util.Collections;
import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {
        return Collections.emptyList();
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return new SubscriptionResponseDto();
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return new SubscriptionResponseDto();
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return new SubscriptionResponseDto();
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {

    }
}
