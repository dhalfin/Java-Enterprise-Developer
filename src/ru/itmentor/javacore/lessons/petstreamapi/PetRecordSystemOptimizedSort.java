package ru.itmentor.javacore.lessons.petstreamapi;

import java.util.*;
import java.util.stream.Collectors;

public class PetRecordSystemOptimizedSort implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();
    private final Set<Pet> petSet = new TreeSet<>();

    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);
        petSet.add(pet);
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
            Pet pet = petsMap.get(petId);
            petSet.remove(pet);
            pet.setPerson(newOwner);
            petSet.add(pet);
        }
    }

    @Override
    public void changePetName(int petId, String newName) {
        if (petsMap.containsKey(petId)) {
            Pet pet = petsMap.get(petId);
            petSet.remove(pet);
            pet.setNickname(newName);
            petSet.add(pet);
        }
    }

    @Override
    public void changePetWeight(int petId, double newWeight) {
        if (petsMap.containsKey(petId)) {
            Pet pet = petsMap.get(petId);
            petSet.remove(pet);
            pet.setWeight(newWeight);
            petSet.add(pet);
        }
    }

    @Override
    public void printAllPetsSorted() {
        petSet.forEach(System.out::println);
    }
}
