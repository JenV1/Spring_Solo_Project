package com.example.soloSpringFirstProject.respository;

import com.example.soloSpringFirstProject.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query(value = "SELECT OWNER.FIRST_NAME, VET.NAME FROM OWNER " +
            "INNER JOIN PET " +
            "ON OWNER.ID = PET.OWNER_ID " +
            "INNER JOIN ASSIGNMENTS " +
            "ON PET.ID = ASSIGNMENTS.PET_ID " +
            "INNER JOIN VET " +
            "ON VET.ID = ASSIGNMENTS.VET_ID", nativeQuery = true)
    List getOwnersAndAssociatedVets();


}
