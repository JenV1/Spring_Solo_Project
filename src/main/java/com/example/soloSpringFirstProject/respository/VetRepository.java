package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
