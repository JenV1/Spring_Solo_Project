package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.model.Owner;
import com.example.soloSpringFirstProject.respository.OwnerRepository;
import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return ResponseEntity.ok().body(owners);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Optional<Owner>> getIndividualOwner(@PathVariable Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return ResponseEntity.ok().body(owner);
    }

}
