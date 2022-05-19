package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.model.Vet;
import com.example.soloSpringFirstProject.respository.PetRepository;
import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VetController {

    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    public VetController(VetRepository vetRepository, PetRepository petRepository) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
    }

    @GetMapping("/vets")
    public ResponseEntity<List<Vet>> getVets() {
        List<Vet> vets = vetRepository.findAll();
        return ResponseEntity
                .ok()
                .body(vets);
    }

    @GetMapping("/vets/{id}")
    public ResponseEntity<Optional<Vet>> getIndividualVet(@PathVariable Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        return ResponseEntity
                .ok()
                .body(vet);
    }

    @PostMapping("/vets")
    public void postVet(@RequestParam String name, @RequestParam int foundingYear) {
        Vet vet = new Vet(null, name, foundingYear, null);
        vetRepository.save(vet);
    }

    @PostMapping("/assignments")
    public void addAssignment(@RequestParam Long pet_id, @RequestParam Long vet_id) {
        if (vetRepository.findById(vet_id).isPresent() && petRepository.findById(pet_id).isPresent()
        && vetRepository.checkAssociationDoesNotExist(pet_id, vet_id).size() == 0) {
            vetRepository.addPetVetAssociation(pet_id, vet_id);
        } else {
            System.out.println("Error caught.");
        }
    }

    @DeleteMapping("/vets/{id}")
    public void deleteVet(@PathVariable Long id) {
        vetRepository.deleteVetFromAssignments(id);
        try {
            vetRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Vet doesn't exist.");
        }
    }

}
