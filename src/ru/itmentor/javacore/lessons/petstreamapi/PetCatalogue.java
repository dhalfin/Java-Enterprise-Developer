package ru.itmentor.javacore.lessons.petstreamapi;

import java.util.List;

public interface PetCatalogue {

    void addPet(Pet pet) throws PetExistsException;

    List<Pet> getAllPetsByName(String petName);

    void changePetOwner(int petId, Person newOwner);

    void changePetName(int petId, String newName);

    void changePetWeight(int petId, double newWeight);

    void printAllPetsSorted();
}
