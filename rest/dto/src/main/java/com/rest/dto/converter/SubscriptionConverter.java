package com.rest.dto.converter;

import java.time.LocalDate;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.model.Subscription;
import com.rest.dto.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

    @Override
    public Subscription convert(SubscriptionRequestDto subscriptionRequestDto) {
         Long id = subscriptionRequestDto.getId();
         User user = getUser(subscriptionRequestDto.getUserId());
         LocalDate startDate = subscriptionRequestDto.getStartDate();
        return new Subscription(id, user, startDate);
    }

    public User getUser(Long userId) {
        return new User();
    }
}
