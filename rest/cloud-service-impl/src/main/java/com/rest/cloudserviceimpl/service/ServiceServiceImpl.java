package com.rest.cloudserviceimpl.service;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.serviceapi.service.ServiceService;

import java.util.Collections;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
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
