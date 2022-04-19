package com.exceptionhandling.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LaptopDetail {
    @Id
    @SequenceGenerator(
            name = "laptop_details_sequence",
            sequenceName = "laptop_details_sequence"
    )
    private Long id;
    private String ram;
    private String processor;
    private String hdd;
}
