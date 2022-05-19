package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.model.Owner;
import com.example.soloSpringFirstProject.respository.OwnerRepository;
import com.example.soloSpringFirstProject.respository.PetRepository;
import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ownersAndVets")
    public ResponseEntity<List> getOwnersAndTheirAssociatedVets() {
        List ownersAndVets = ownerRepository.getOwnersAndAssociatedVets();
        return ResponseEntity
                .ok()
                .body(ownersAndVets);
    }

    @PostMapping("/owners")
    public void postOwner(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        Owner owner = new Owner(null, firstName, lastName, address, null);
        ownerRepository.save(owner);
    }

    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@PathVariable Long id) {
        try {
            ownerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Owner doesn't exist.");
        }
    }

}
