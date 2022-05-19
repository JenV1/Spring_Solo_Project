package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.model.Vet;
import com.example.soloSpringFirstProject.respository.VetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VetController {

    private final VetRepository vetRepository;

    public VetController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
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

    @DeleteMapping("/vets/{id}")
    public void deleteVet(@PathVariable Long id) {
        vetRepository.deleteById(id);
    }
}
