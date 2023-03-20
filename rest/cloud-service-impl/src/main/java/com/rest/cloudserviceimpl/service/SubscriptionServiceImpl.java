package com.rest.cloudserviceimpl.service;

import com.rest.dto.converter.SubscriptionConverter;
import com.rest.dto.converter.SubscriptionResponseConverter;
import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.dto.model.Subscription;
import com.rest.serviceapi.service.SubscriptionService;
import com.rest.servicedb.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final UserServiceImpl userService;

    private final SubscriptionConverter subscriptionConverter;

    private final SubscriptionResponseConverter subscriptionResponseConverter;

    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionRepository.findAll().stream()
                .map(subscriptionResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return subscriptionResponseConverter.convert(findSubscriptionById(subscriptionId));
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return subscriptionResponseConverter.convert(subscriptionRepository.save(subscriptionConverter.convert(subscriptionRequestDto,
                userService.findUserById(subscriptionRequestDto.getUserId()))));
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {

        Subscription subscription = findSubscriptionById(subscriptionRequestDto.getId());
        if (subscription != null) {
            subscription = subscriptionConverter.convert(subscriptionRequestDto,
                    userService.findUserById(subscriptionRequestDto.getUserId()));
        }

        assert subscription != null;
        return subscriptionResponseConverter.convert(subscriptionRepository.save(subscription));
    }

    @Override
    public boolean deleteSubscription(Long subscriptionId) {
        Subscription subscription = findSubscriptionById(subscriptionId);
        if (subscription != null) {
            subscriptionRepository.delete(subscription);
            return true;
        } else {
            return false;
        }
    }

    private Subscription findSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Subscription with that ID: %d Not found.", id)));
    }
}
