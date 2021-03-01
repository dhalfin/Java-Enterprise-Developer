package ru.itmentor.javacore.lessons.petstreamapi;

import java.util.*;
import java.util.stream.Collectors;

public class PetRecordSystemOptimizedName implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();
    private final Map<String, List<Pet>> nameMap = new HashMap<>();

    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);
        addPetToNameMap(pet);
    }

    private void addPetToNameMap(Pet pet) {
        if (!nameMap.containsKey(pet.getNickname())) {
            nameMap.put(pet.getNickname(), new ArrayList<>());
        }
        nameMap.get(pet.getNickname())
                .add(pet);
    }

    @Override
    public List<Pet> getAllPetsByName(String petName) {
        List<Pet> result = new ArrayList<>();
        if (nameMap.containsKey(petName)) {
            result.addAll(nameMap.get(petName));
        }
        return result;
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
            Pet pet = petsMap.get(petId);
            nameMap.get(pet.getNickname())
                    .remove(pet);
            if (nameMap.get(pet.getNickname())
                    .isEmpty()) {
                nameMap.remove(pet.getNickname());
            }
            pet.setNickname(newName);
            addPetToNameMap(pet);
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
        List<Pet> sortedPets = pets.stream()
                .sorted()
                .collect(Collectors.toList());
        sortedPets.forEach(System.out::println);
    }
}
