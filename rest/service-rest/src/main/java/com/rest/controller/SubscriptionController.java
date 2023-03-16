package com.rest.controller;

import com.rest.cloudserviceimpl.service.SubscriptionServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;

import java.util.List;

public class SubscriptionController {

    private SubscriptionServiceImpl subscriptionService;

    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscription();
    }

    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return subscriptionService.getSubscription(subscriptionId);
    }

    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.createSubscription(subscriptionRequestDto);
    }

    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.updateSubscription(subscriptionRequestDto);
    }

    public void deleteSubscription(Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }


}
