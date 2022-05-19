package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface VetRepository extends JpaRepository<Vet, Long> {

    @Modifying
    @Query(value = "INSERT INTO ASSIGNMENTS (PET_ID, VET_ID) VALUES (:PET_ID, :VET_ID)", nativeQuery = true)
    @Transactional
    void addPetVetAssociation(@Param("PET_ID") Long pet_id, @Param("VET_ID") Long vet_id);

    @Modifying
    @Query(value = "DELETE FROM ASSIGNMENTS WHERE VET_ID = :VET_ID", nativeQuery = true)
    @Transactional
    void deleteVetFromAssignments(@Param("VET_ID") Long vet_id);

    @Query(value = "SELECT * FROM ASSIGNMENTS WHERE PET_ID = :PET_ID AND VET_ID = :VET_ID", nativeQuery = true)
    List checkAssociationDoesNotExist(@Param("PET_ID") Long pet_id, @Param("VET_ID") Long vet_id);

}
