package ru.itmentor.javacore.lessons.petstreamapi;

import java.util.*;
import java.util.stream.Collectors;

public class PetRecordSystemSimple implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();

    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);
    }

    @Override
    public List<Pet> getAllPetsByName(String petName) {
        return petsMap.values().stream()
                .filter(pet -> pet.getNickname().equals(petName))
                .collect(Collectors.toList());
    }

    @Override
    public void changePetOwner(int petId, Person newOwner) {
        if (petsMap.containsKey(petId)) {
            petsMap.get(petId).setPerson(newOwner);
        }
    }

    @Override
    public void changePetName(int petId, String newName) {
        if (petsMap.containsKey(petId)) {
            petsMap.get(petId).setNickname(newName);
        }
    }

    @Override
    public void changePetWeight(int petId, double newWeight) {
        if (petsMap.containsKey(petId)) {
            petsMap.get(petId).setWeight(newWeight);
        }
    }

    @Override
    public void printAllPetsSorted() {
        List<Pet> pets = new ArrayList<>(petsMap.values());
        Collections.sort(pets);
        pets.forEach(System.out::println);
    }
}
