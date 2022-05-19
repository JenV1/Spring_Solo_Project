package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT * FROM PET WHERE PET.AGE>= :PET_AGE", nativeQuery = true)
    public List<Pet> returnPetsAboveAge(@Param("PET_AGE") int pet_age );

}
