package com.exceptionhandling.services;

import com.exceptionhandling.dtos.DecadevDto;
import com.exceptionhandling.models.Decadev;

import java.util.List;

public interface DecadevService {
    DecadevDto createDecadev(DecadevDto decadevDto);
    DecadevDto updateDecadev(long id, DecadevDto decadevDto);
    void deleteDecadev(long id);
    DecadevDto getDecadev(long id);
    List<DecadevDto> getDecadevs();
}
