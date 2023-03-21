package com.rest.testutil;

import java.time.LocalDate;

import com.rest.dto.dto.SubscriptionRequestDto;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.dto.model.Subscription;

public class SubscriptionUtil {

    public static final Long ID = 1L;
    public static final Long USER_ID = 1L;
    public static final LocalDate START_DATE = LocalDate.now();
    public static final String START_DATE_STRING = String.valueOf(LocalDate.now());
    public static final String SUBSCRIPTION_NOT_FOUND_EXCEPTION_MESSAGE = "Subscription with that ID: %d Not found.";

    public static Subscription subscription() {
        return new Subscription(ID, UserUtil.user(), START_DATE);
    }

    public static SubscriptionResponseDto subscriptionResponseDto() {
        return new SubscriptionResponseDto(ID, USER_ID, START_DATE_STRING);
    }

    public static SubscriptionRequestDto subscriptionRequestDto() {
        return new SubscriptionRequestDto(ID, USER_ID, START_DATE);
    }

}
