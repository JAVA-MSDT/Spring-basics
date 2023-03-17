package com.rest.controller;

import java.util.List;

import com.rest.cloudserviceimpl.service.SubscriptionServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionServiceImpl subscriptionService;

    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscription();
    }

    @GetMapping("/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable("id") Long subscriptionId) {
        return subscriptionService.getSubscription(subscriptionId);
    }

    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.createSubscription(subscriptionRequestDto);
    }

    @PutMapping
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionService.updateSubscription(subscriptionRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable("id") Long subscriptionId) {
        return subscriptionService.deleteSubscription(subscriptionId);
    }

}
