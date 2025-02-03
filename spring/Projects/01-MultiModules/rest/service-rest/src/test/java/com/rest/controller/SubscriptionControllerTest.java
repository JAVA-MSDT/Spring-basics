package com.rest.controller;

import java.util.List;
import java.util.Objects;

import com.rest.cloudserviceimpl.service.SubscriptionServiceImpl;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.modelassempler.SubscriptionAssembler;
import com.rest.testutil.SubscriptionUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubscriptionControllerTest {

    @InjectMocks
    private SubscriptionController subscriptionController;

    @Mock
    private SubscriptionServiceImpl subscriptionService;

    @Mock
    private SubscriptionAssembler subscriptionAssembler;

    @Test
    void getAllSubscription() {
        // Given
        List<SubscriptionResponseDto> subscriptionResponseDtos = List.of(SubscriptionUtil.subscriptionResponseDto());
        List<EntityModel<SubscriptionResponseDto>> subscriptionEntityModels = List.of(
                EntityModel.of(subscriptionResponseDtos.get(0)));

        // When
        when(subscriptionService.getAllSubscription()).thenReturn(subscriptionResponseDtos);
        when(subscriptionAssembler.toCollectionModel(any())).thenReturn(CollectionModel.of(subscriptionEntityModels));

        // Then
        ResponseEntity<CollectionModel<EntityModel<SubscriptionResponseDto>>> subscriptionCollectionModelResponseEntity = subscriptionController.getAllSubscription();
        assertEquals(subscriptionCollectionModelResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(subscriptionCollectionModelResponseEntity.getBody()).getContent().size(),
                1);
    }

    @Test
    void getSubscription() {
        // Given
        SubscriptionResponseDto subscriptionResponseDto = SubscriptionUtil.subscriptionResponseDto();
        Long subscriptionId = SubscriptionUtil.ID;
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = EntityModel.of(
                subscriptionResponseDto);

        // When
        when(subscriptionService.getSubscription(anyLong())).thenReturn(subscriptionResponseDto);
        when(subscriptionAssembler.toModel(any(SubscriptionResponseDto.class))).thenReturn(
                subscriptionResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<SubscriptionResponseDto>> subscriptionEntity = subscriptionController.getSubscription(
                subscriptionId);
        assertEquals(subscriptionEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(subscriptionEntity.getBody(), subscriptionResponseDtoEntityModel);
    }

    @Test
    void createSubscription() {
        // Given
        SubscriptionResponseDto subscriptionResponseDto = SubscriptionUtil.subscriptionResponseDto();
        SubscriptionRequestDto subscriptionRequestDto = SubscriptionUtil.subscriptionRequestDto();
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = EntityModel.of(
                subscriptionResponseDto);

        // When
        when(subscriptionService.createSubscription(any(SubscriptionRequestDto.class))).thenReturn(
                subscriptionResponseDto);
        when(subscriptionAssembler.toModel(any(SubscriptionResponseDto.class))).thenReturn(
                subscriptionResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<SubscriptionResponseDto>> subscriptionResponseEntity = subscriptionController.createSubscription(
                subscriptionRequestDto);
        assertEquals(subscriptionResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(subscriptionResponseEntity.getBody(), subscriptionResponseDtoEntityModel);
    }

    @Test
    void updateSubscription() {
        // Given
        SubscriptionResponseDto subscriptionResponseDto = SubscriptionUtil.subscriptionResponseDto();
        SubscriptionRequestDto subscriptionRequestDto = SubscriptionUtil.subscriptionRequestDto();
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = EntityModel.of(
                subscriptionResponseDto);

        // When
        when(subscriptionService.updateSubscription(any(SubscriptionRequestDto.class))).thenReturn(
                subscriptionResponseDto);
        when(subscriptionAssembler.toModel(any(SubscriptionResponseDto.class))).thenReturn(
                subscriptionResponseDtoEntityModel);

        // Then
        ResponseEntity<EntityModel<SubscriptionResponseDto>> subscriptionResponseEntity = subscriptionController.updateSubscription(
                subscriptionRequestDto);
        assertEquals(subscriptionResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(subscriptionResponseEntity.getBody(), subscriptionResponseDtoEntityModel);
    }

    @Test
    void deleteSubscription() {
        // Given
        Long subscriptionId = SubscriptionUtil.ID;

        // When
        when(subscriptionService.deleteSubscription(anyLong())).thenReturn(true);

        // Then
        boolean subscriptionDeleteStatus = subscriptionController.deleteSubscription(subscriptionId);
        assertTrue(subscriptionDeleteStatus);
    }
}
