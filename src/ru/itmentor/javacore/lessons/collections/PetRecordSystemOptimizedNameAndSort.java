package ru.itmentor.javacore.lessons.collections;

import java.util.*;

public class PetRecordSystemOptimizedNameAndSort implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();
    private final Map<String, List<Pet>> nameMap = new HashMap<>();
    private final Set<Pet> petSet = new TreeSet<>();

    //O(1) + O(1) + O(1) + O(log (n) = O(log (n))
    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {//O(1)
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);//O(1)
        addPetToNameMap(pet);//O(1)
        petSet.add(pet);//O(log (n))
    }

    //O(1) + O(1) + O(1) + 0(1) = 0(1)
    private void addPetToNameMap(Pet pet) {
        if (!nameMap.containsKey(pet.getNickname())) {//O(1)
            nameMap.put(pet.getNickname(), new ArrayList<>());//O(1)
        }
        nameMap.get(pet.getNickname())//O(1)
                .add(pet);//O(1)
    }

    //O(1) + 0(1) = 0(1)
    @Override
    public List<Pet> getAllPetsByName(String petName) {
        List<Pet> result = new ArrayList<>();
        if (nameMap.containsKey(petName)) {//O(1)
            result.addAll(nameMap.get(petName));//O(1)
        }
        return result;
    }

    //O(1) + 0(1) + O(log (n)) + O(1) + O(log (n))= O(log (n))
    @Override
    public void changePetOwner(int petId, Person newOwner) {
        if (petsMap.containsKey(petId)) {//O(1)
            Pet pet = petsMap.get(petId);//O(1)
            petSet.remove(pet);//O(log (n))
            pet.setPerson(newOwner);//O(1)
            petSet.add(pet);//O(log (n))
        }
    }

    //O(1) + 0(1) + O(1) + 0(1) + 0(1) + O(1) + 0(1) + O(log (n)) + O(1) + 0(1) + O(log (n)) = O(log (n))
    @Override
    public void changePetName(int petId, String newName) {
        if (petsMap.containsKey(petId)) {//O(1)
            Pet pet = petsMap.get(petId);//O(1)
            nameMap.get(pet.getNickname())//O(1)
                    .remove(pet);//O(1)
            if (nameMap.get(pet.getNickname())//O(1)
                    .isEmpty()) {//O(1)
                nameMap.remove(pet.getNickname());//O(1)
            }
            petSet.remove(pet);//O(log (n))
            pet.setNickname(newName);//O(1)
            addPetToNameMap(pet);//O(1)
            petSet.add(pet);//O(log (n))
        }
    }

    //O(1) + 0(1) + O(log (n)) + 0(1) + O(log (n)) = O(log (n))
    @Override
    public void changePetWeight(int petId, double newWeight) {
        if (petsMap.containsKey(petId)) {//O(1)
            Pet pet = petsMap.get(petId);//O(1)
            petSet.remove(pet);//O(log (n))
            pet.setWeight(newWeight);//O(1)
            petSet.add(pet);//O(log (n))
        }
    }

    //O(log (n)) + O(1) = O(log (n))
    @Override
    public void printAllPetsSorted() {
        for (Pet pet : petSet) {//O(log (n))
            System.out.println(pet);//O(1)
        }
    }
}
