package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
