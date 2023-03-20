package com.rest.controller;

import com.rest.cloudserviceimpl.service.SubscriptionServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.modelassempler.SubscriptionAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionServiceImpl subscriptionService;
    private final SubscriptionAssembler subscriptionAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<SubscriptionResponseDto>>> getAllSubscription() {
        return ResponseEntity.ok(subscriptionAssembler.toCollectionModel(subscriptionService.getAllSubscription()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> getSubscription(@PathVariable("id") Long subscriptionId) {
        SubscriptionResponseDto subscriptionResponseDto = subscriptionService.getSubscription(subscriptionId);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = subscriptionAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PostMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = subscriptionService.createSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = subscriptionAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PutMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = subscriptionService.updateSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = subscriptionAssembler.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable("id") Long subscriptionId) {
        return subscriptionService.deleteSubscription(subscriptionId);
    }

}
