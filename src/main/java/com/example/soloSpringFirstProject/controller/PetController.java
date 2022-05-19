package com.example.soloSpringFirstProject.controller;

import com.example.soloSpringFirstProject.model.Pet;
import com.example.soloSpringFirstProject.respository.OwnerRepository;
import com.example.soloSpringFirstProject.respository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetController(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @RequestMapping(value = "pets",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Pet>> getPetsOverAge(@RequestParam(value = "petAge",
            defaultValue = "0") int petAge) {
        List<Pet> pets = petRepository.returnPetsAboveAge(petAge);
        return ResponseEntity
                .ok()
                .body(pets);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Optional<Pet>> getIndividualPet(@PathVariable Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return ResponseEntity
                .ok()
                .body(pet);
    }

    @PostMapping("/pets")
    public void postPet(@RequestParam String name, @RequestParam String animalType, @RequestParam int age,
                        @RequestParam Long ownerID) {
        Pet pet = new Pet(null, name, animalType, age, ownerRepository.getById(ownerID), null);
        petRepository.save(pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }
}
