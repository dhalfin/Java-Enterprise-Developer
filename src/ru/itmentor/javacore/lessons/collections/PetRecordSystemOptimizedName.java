package ru.itmentor.javacore.lessons.collections;

import java.util.*;

public class PetRecordSystemOptimizedName implements PetCatalogue {

    private final Map<Integer, Pet> petsMap = new HashMap<>();
    private final Map<String, List<Pet>> nameMap = new HashMap<>();

    //1) Проверяем есть ли уже животные с таким id, если да - выбрасываем ошибку
    //2) Добавляем в основную карту пару айди животного - животное
    //O(1) + O(1) + O(1) = O(1)
    @Override
    public void addPet(Pet pet) throws PetExistsException {
        if (petsMap.containsKey(pet.getId())) {//O(1)
            throw new PetExistsException(pet);
        }
        petsMap.put(pet.getId(), pet);//O(1)
        addPetToNameMap(pet);//O(1)
    }

    //3) Смотрим, есть ли у нас уже питомцы с такой кличкой, если нет - добавляем в карту имен пару
    // - кличка животного, новый список (пустой)
    //4) Получаем по кличке животного список из nameMap и добавляем в него наше новое животное
    //O(1) + O(1) + O(1) + O(1) = O(1)
    private void addPetToNameMap(Pet pet) {
        if (!nameMap.containsKey(pet.getNickname())) {//O(1)
            nameMap.put(pet.getNickname(), new ArrayList<>());//O(1)
        }
        nameMap.get(pet.getNickname())//O(1)
                .add(pet);//O(1)
    }

    //O(1) + O(1) = O(1)
    @Override
    public List<Pet> getAllPetsByName(String petName) {
        List<Pet> result = new ArrayList<>();
        if (nameMap.containsKey(petName)) {//O(1)
            result.addAll(nameMap.get(petName));//O(1)
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

    //O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(1)
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
            pet.setNickname(newName);//O(1)
            addPetToNameMap(pet);//O(1)
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
