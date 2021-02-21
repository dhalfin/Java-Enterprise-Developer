package ru.itmentor.javacore.lessons.petstreamapi;

public class PetExistsException extends Exception {

    private Pet pet;

    public PetExistsException(Pet pet) {
        this.pet = pet;
    }

    public String toString() {
        return "Pet " + pet + " already exists";
    }
}

