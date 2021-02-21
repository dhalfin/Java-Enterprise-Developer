package ru.itmentor.javacore.lessons.collections;

import java.util.List;

public interface PetCatalogue {

    void addPet(Pet pet);

    List<Pet> getAllPetsByName(String petName);

    void changePetOwner(int petId, Person newOwner);

    void changePetName(int petId, String newName);

    void changePetWeight(int petId, double newWeight);

    void printAllPetsSorted();
}
