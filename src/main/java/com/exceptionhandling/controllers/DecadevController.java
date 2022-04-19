package com.exceptionhandling.controllers;

import com.exceptionhandling.dtos.DecadevDto;
import com.exceptionhandling.services.DecadevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "decagon/api/")
public class DecadevController {
    private final DecadevService service;

    @Autowired
    public DecadevController(DecadevService service) {
        this.service = service;
    }
    @PostMapping("/new")
    public ResponseEntity<DecadevDto> createDecadev(@RequestBody DecadevDto decadevDto){
        DecadevDto decadevDto1 = service.createDecadev(decadevDto);
        return new ResponseEntity<>(
                decadevDto1,
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public List<DecadevDto> findAllDecadevs(){
        return service.getDecadevs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DecadevDto> getById(@PathVariable long id){
        DecadevDto decadevDto = service.getDecadev(id);
        return new ResponseEntity<>(
                decadevDto,
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public DecadevDto updateDecadev(@PathVariable long id,
                              @RequestBody DecadevDto decadevDto){
       return service.updateDecadev(id, decadevDto);
    }

}
