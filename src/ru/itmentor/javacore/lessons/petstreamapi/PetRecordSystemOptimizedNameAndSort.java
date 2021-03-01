package ru.itmentor.javacore.lessons.petstreamapi;

import java.util.*;

public class PetRecordSystemOptimizedNameAndSort implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();
    private final Map<String, List<Pet>> nameMap = new HashMap<>();
    private final Set<Pet> petSet = new TreeSet<>();

    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);
        addPetToNameMap(pet);
        petSet.add(pet);
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
            nameMap.get(pet.getNickname())
                    .remove(pet);
            if (nameMap.get(pet.getNickname())
                    .isEmpty()) {
                nameMap.remove(pet.getNickname());
            }
            petSet.remove(pet);
            pet.setNickname(newName);
            addPetToNameMap(pet);
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
