package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
