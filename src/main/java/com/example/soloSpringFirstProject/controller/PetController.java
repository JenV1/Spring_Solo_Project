package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.respository.PetRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
}
