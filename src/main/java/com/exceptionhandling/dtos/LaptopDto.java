package com.exceptionhandling.dtos;

import com.exceptionhandling.models.LaptopDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopDto {
    private Long id;
    private String title;
    private LaptopDetail laptopDetail;
}
