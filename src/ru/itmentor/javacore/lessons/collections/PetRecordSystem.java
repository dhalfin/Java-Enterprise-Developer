package ru.itmentor.javacore.lessons.collections;

import java.util.*;

public class PetRecordSystem implements PetCatalogue {

    List<Pet> pets = new ArrayList<>();
    Map<Integer, Pet> petsMap = new HashMap<>();

    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (pets.contains(pet)) {
            pets.add(pet);
        } else {
            throw new PetExistsException(pet);
        }
    }

    @Override
    public List<Pet> getAllPetsByName(String petName) {
        List<Pet> result = new ArrayList<>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getNickname().equals(petName)) {
                result.add(pets.get(i));
            }
        }
        return result;
    }

    @Override
    public void changePetOwner(int petId, Person newOwner) {
        for (int i = 0; i < petsMap.size(); i++) {
            if (petsMap.get(i).getId() == petId) {
                petsMap.get(i).setPerson(newOwner);
            }
        }
    }

    @Override
    public void changePetName(int petId, String newName) {
        for (int i = 0; i < petsMap.size(); i++) {
            if (petsMap.get(i).getId() == petId) {
                petsMap.get(i).setNickname(newName);
            }
        }
    }

    @Override
    public void changePetWeight(int petId, double newWeight) {
        for (int i = 0; i < petsMap.size(); i++) {
            if (petsMap.get(i).getId() == petId) {
                petsMap.get(i).setWeight(newWeight);
            }
        }
    }

    @Override
    public void printAllPetsSorted() {
        Collections.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                int comp = o1.getPerson().getName().compareTo(o2.getPerson().getName());
                int comp1 = o1.getNickname().compareTo(o2.getNickname());
                if (comp != 0) {
                    return comp;
                } else if (comp1 != 0) {
                    return comp1;
                } else {
                    return (int) (o1.getWeight() - o2.getWeight());
                }
            }
        });
        System.out.println(pets);
    }
}
