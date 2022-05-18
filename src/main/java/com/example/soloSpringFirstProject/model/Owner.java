package com.example.soloSpringFirstProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;

    @OneToMany(mappedBy ="owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"owner", "vets"})
    private List<Pet> ownedPets;

    public Owner() {
    }

    public Owner(Long id, String firstName, String lastName, String address, List<Pet> ownedPets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ownedPets = ownedPets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getOwnedPets() {
        return ownedPets;
    }

    public void setOwnedPets(List<Pet> ownedPets) {
        this.ownedPets = ownedPets;
    }
}
