package com.example.soloSpringFirstProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String animalType;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "assignments",
        joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name ="vet_id")
    )
    @JsonIgnoreProperties(value = {"pets"})
    private List<Vet> vets;

    public Pet() {
    }

    public Pet(Long id, String name, String animalType, int age, List<Vet> vets) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.age = age;
        this.vets = vets;
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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Vet> getVets() {
        return vets;
    }

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
}