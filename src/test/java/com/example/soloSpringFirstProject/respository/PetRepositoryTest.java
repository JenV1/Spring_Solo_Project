package com.example.soloSpringFirstProject.respository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetRepositoryTest {

    @Autowired
    private PetRepository petRepository;

    @Test
    void returnPetsAboveAge() {
        assertEquals(3, petRepository.returnPetsAboveAge(5).size());
    }
}