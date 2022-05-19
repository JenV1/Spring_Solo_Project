package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.respository.OwnerRepository;
import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
