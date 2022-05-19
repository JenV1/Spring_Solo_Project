package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VetController {

    private final VetRepository vetRepository;

    public VetController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }
}
