package com.rest.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SubscriptionRequestDto {
    private Long id;
    private Long userId;
    private LocalDate startDate;
}
