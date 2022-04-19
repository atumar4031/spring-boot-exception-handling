package com.exceptionhandling.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopDetailsDto {
    private Long id;
    private String ram;
    private String processor;
    private String hdd;
}
