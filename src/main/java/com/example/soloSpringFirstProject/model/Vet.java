package com.example.soloSpringFirstProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int foundingYear;

    @ManyToMany(mappedBy = "vets")
    @JsonIgnoreProperties(value = {"vets"})
    private List<Pet> pets;

    public Vet() {
    }

    public Vet(Long id, String name, int foundingYear, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.foundingYear = foundingYear;
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
