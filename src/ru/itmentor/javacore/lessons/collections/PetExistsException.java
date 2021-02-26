package ru.itmentor.javacore.lessons.collections;


import java.util.List;

public class PetExistsException extends Exception {

    private Pet pet;
    private String name;
    private List<Pet> pets;

    public PetExistsException(Pet pet) {
        this.pet = pet;
    }

    public PetExistsException(String name, List<Pet> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String toString() {
        return "Pet " + pet + " already exists";
    }
}

