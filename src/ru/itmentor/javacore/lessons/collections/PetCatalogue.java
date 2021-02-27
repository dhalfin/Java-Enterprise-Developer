package ru.itmentor.javacore.lessons.collections;

import java.util.List;
import java.util.Map;

public interface PetCatalogue {

    void addPet(Pet pet) throws PetExistsException;

    void getAllPetsByName(String petName);
    //List<Pet> getAllPetsByName(String petName);

    void changePetOwner(int petId, Person newOwner);

    void changePetName(int petId, String newName, String oldName);

    void changePetWeight(int petId, double newWeight);

    void printAllPetsSorted();
}
