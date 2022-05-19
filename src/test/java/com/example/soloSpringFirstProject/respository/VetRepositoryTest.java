package com.example.soloSpringFirstProject.respository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VetRepositoryTest {

    @Autowired
    private VetRepository vetRepository;

    @Test
    void checkAssociationDoesNotExist() {
        assertEquals(0, vetRepository.checkAssociationDoesNotExist(4l,4l).size());
    }
}