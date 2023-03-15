package com.rest.controller;

import com.rest.cloudserviceimpl.service.ServiceServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;

import java.util.Collections;
import java.util.List;

public class ServiceController {

    private ServiceServiceImpl serviceService;

    public List<SubscriptionResponseDto> getAllSubscription() {
        return serviceService.getAllSubscription();
    }

    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return serviceService.getSubscription(subscriptionId);
    }

    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return serviceService.createSubscription(subscriptionRequestDto);
    }

    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return serviceService.updateSubscription(subscriptionRequestDto);
    }

    public void deleteSubscription(Long subscriptionId) {
        serviceService.deleteSubscription(subscriptionId);
    }


}
