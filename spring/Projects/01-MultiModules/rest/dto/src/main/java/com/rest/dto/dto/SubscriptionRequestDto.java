package com.rest.dto.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SubscriptionRequestDto {
    private Long id;
    private Long userId;
    private LocalDate startDate;
}
