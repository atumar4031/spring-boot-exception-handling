package com.exceptionhandling.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DecadevDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String stack;
    private String pod;
}