package com.exceptionhandling.services.impls;

import com.exceptionhandling.dtos.DecadevDto;
import com.exceptionhandling.exceptions.DecadevAlreadyExist;
import com.exceptionhandling.exceptions.DecadevNotFound;
import com.exceptionhandling.models.Decadev;
import com.exceptionhandling.repositories.DecadevRepository;
import com.exceptionhandling.services.DecadevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DecadevServiceImpl implements DecadevService {

    private final DecadevRepository decadevRepository;

    @Autowired
    public DecadevServiceImpl(DecadevRepository decadevRepository) {
        this.decadevRepository = decadevRepository;
    }

    @Override
    public DecadevDto createDecadev(DecadevDto decadevDto) {
        Optional<Decadev> registed =
                decadevRepository.findByEmail(decadevDto.getEmail());
        if (registed.isPresent())
            throw new DecadevAlreadyExist("this email " + decadevDto.getEmail() + " has been taken");

        Decadev decadev = Decadev.builder()
                .firstname(decadevDto.getFirstname())
                .lastname(decadevDto.getLastname())
                .email(decadevDto.getEmail())
                .stack(decadevDto.getStack())
                .pod(decadevDto.getPod())
                .build();

        return  objectToDto(decadevRepository.save(decadev));
    }

    @Override
    public DecadevDto updateDecadev(long id, DecadevDto decadevDto) {
        Decadev decadev =  decadevRepository.findById(id)
                .orElseThrow(() -> new DecadevNotFound("this Decadev " + decadevDto.getFirstname() + " does not exist"));
        decadev.setFirstname(decadevDto.getFirstname());
        decadev.setLastname(decadevDto.getLastname());
        decadev.setEmail(decadevDto.getEmail());
        decadev.setStack(decadevDto.getStack());
        decadev.setPod(decadevDto.getPod());
        return objectToDto(decadevRepository.save(decadev));


//        Employee employee = repository.findById(id) //
//                .orElseThrow(() -> new EmployeeNotFoundException(id));

//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });

    }

    @Override
    public void deleteDecadev(long id) {
        Decadev registed =  decadevRepository.findById(id)
                .orElseThrow((()->new DecadevNotFound("Decadev not found")));
        decadevRepository.delete(registed);
    }

    @Override
    public DecadevDto getDecadev(long id) {
        Decadev decadev =  decadevRepository.findById(id)
                .orElseThrow(() -> new DecadevNotFound("Decadev not found"));
        return objectToDto(decadev);
    }

    @Override
    public List<DecadevDto> getDecadevs() {
        List<DecadevDto> decadevDtos = new ArrayList<>();
        List<Decadev> decadevs = decadevRepository.findAll();

        if(decadevs.isEmpty())
            throw new DecadevNotFound("No decadev registed yet!!!");

        for (Decadev decadev:  decadevs)
            decadevDtos.add(objectToDto(decadev));
        return decadevDtos;
    }

    public DecadevDto objectToDto(Decadev decadev){
        return  DecadevDto.builder()
                .id(decadev.getId())
                .firstname(decadev.getFirstname())
                .lastname(decadev.getLastname())
                .email(decadev.getEmail())
                .stack(decadev.getStack())
                .pod(decadev.getPod())
                .build();
    }
}
