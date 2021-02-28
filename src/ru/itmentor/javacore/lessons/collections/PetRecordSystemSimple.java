package ru.itmentor.javacore.lessons.collections;

import java.util.*;

public class PetRecordSystemSimple implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();

    //O(1) + O(1) = O(1)
    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {//O(1)
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);//O(1)
    }

    //O(n) + O(1) + O(1) = O(n)
    @Override
    public List<Pet> getAllPetsByName(String petName) {
        List<Pet> result = new ArrayList<>();
        for (Pet pet : petsMap.values()) {//O(n)
            if (pet.getNickname().equals(petName)) {//O(1)
                result.add(pet);//O(1)
            }
        }
        return result;
    }

    //O(1) + O(1) = O(1)
    @Override
    public void changePetOwner(int petId, Person newOwner) {
        if (petsMap.containsKey(petId)) {//O(1)
            petsMap.get(petId).setPerson(newOwner);//O(1)
        }
    }

    //O(1) + O(1) = O(1)
    @Override
    public void changePetName(int petId, String newName) {
        if (petsMap.containsKey(petId)) {//O(1)
            petsMap.get(petId).setNickname(newName);//O(1)
        }
    }

    //O(1) + O(1) = O(1)
    @Override
    public void changePetWeight(int petId, double newWeight) {
        if (petsMap.containsKey(petId)) {//O(1)
            petsMap.get(petId).setWeight(newWeight);//O(1)
        }
    }

    //O(n*log(n)) + O(n) + O(1) = O(n*log(n))
    @Override
    public void printAllPetsSorted() {
        List<Pet> pets = new ArrayList<>(petsMap.values());
        Collections.sort(pets);//O(n*log(n))
        for (Pet pet : pets) {//O(n)
            System.out.println(pet);//O(1)
        }
    }
}
