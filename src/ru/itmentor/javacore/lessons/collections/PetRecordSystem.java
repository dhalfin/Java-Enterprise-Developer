package ru.itmentor.javacore.lessons.collections;

import java.util.*;

public class PetRecordSystem implements PetCatalogue {

    //List<Pet> pets = new ArrayList<>();
   // int ID = 0;
    Map<Integer, Pet> petsMap = new HashMap<>();
    Map<String, List<Pet>> nameMap = new HashMap<>();
   // NavigableSet<Pet> petSet = new TreeSet<>();
    Map<Integer, Pet> petsTreeMap = new TreeMap<>();

    //O(1)
    //1) Проверяем есть ли уже животные с таким id, если да - выбрасываем ошибку
    //2) Добавляем в основную карту пару айди животного - животное
    //3) Смотрим, есть ли у нас уже питомцы с такой кличкой, если нет - добавляем в карту имен пару - кличка животного,
    // новый список (пустой)
    //4) Получаем по кличке животного список из nameMap и добавляем в него наше новое животное
//    @Override
//    public void addPet(Pet pet) throws PetExistsException {
//        if (petsMap.containsKey(pet.getId())) {
//            throw new PetExistsException(pet);
//        }
//        petsMap.put(pet.getId(), pet);
//        if (!nameMap.containsKey(pet.getNickname())) {
//            nameMap.put(pet.getNickname(), new ArrayList<>());
//        }
//        nameMap.get(pet.getNickname()).add(pet);
//    }


    @Override
    public void addPet(Pet pet) throws PetExistsException {
        try {
            if (petsTreeMap.containsValue(pet)) {
                throw new PetExistsException(pet);
            }
//            petSet.pollLast();
//            changePetOwner(pet.getId(), pet.getPerson());
//            petSet.add(pet);
            petsTreeMap.put(pet.getId(), pet);
           // ID++;
        } catch (PetExistsException ex){
            System.out.println("Such a pet already exists!");
        }
    }

    //O(1)
    @Override
    public void getAllPetsByName(String petName) {
        List<Pet> petObjects = new ArrayList<Pet>(petsTreeMap.values());
//        for (int i = 0; i < pets.size(); i++) {
//            if (pets.get(i).getNickname().equals(petName)) {
//                result.add(pets.get(i));
//            }
//        }
//        return result;

        for (Pet petObj : petObjects) {
            if (petObj.getNickname().equals(petName)) {
                System.out.println("ID : " + petObj.getId());
                System.out.println("Nickname : " + petObj.getNickname());
                System.out.println("Owner : " + petObj.getPerson().getName());
            }
        }
//        if (nameMap.containsKey(petName)) {
//            result = nameMap.get(petName);
//        }
//        return result;
    }

    //O(1)
    @Override
    public void changePetOwner(int petId, Person newOwner) {
        if (petsMap.containsKey(petId)) {
            petsMap.get(petId).setPerson(newOwner);
        }
    }

    //O(n)
    @Override
    public void changePetName(int petId, String newName, String oldName) {
        for (int i = 0; i < petsMap.size(); i++) {
            if (petsMap.get(i).getId() == petId) {
                petsMap.get(i).setNickname(newName);
            }
        }
//        for (int i = 0; i < nameMap.size(); i++) {
//            if (nameMap.get(i))
//        }

        for (Map.Entry<String, List<Pet>> entry : nameMap.entrySet()) {
            if (nameMap.containsKey(oldName)) {
                List<Pet> oldNameList = entry.getValue();
                oldNameList.remove(oldName);
                nameMap.put(newName, new ArrayList<>());
            }
        }
    }

    //O(1)
    @Override
    public void changePetWeight(int petId, double newWeight) {
        if (petsMap.containsKey(petId)) {
            petsMap.get(petId).setWeight(newWeight);
        }
    }

    //0(n)
    @Override
    public void printAllPetsSorted() {

        for (int i = 0; i < petsTreeMap.size(); i++) {
            System.out.println(petsTreeMap.get(i));
        }

    }

    //O(n log n)
//    @Override
//    public void printAllPetsSorted() {
//        pets.sort(new Comparator<Pet>() {
//            @Override
//            public int compare(Pet o1, Pet o2) {
//                int comp = o1.getPerson().getName().compareTo(o2.getPerson().getName());
//                int comp1 = o1.getNickname().compareTo(o2.getNickname());
//                if (comp != 0) {
//                    return comp;
//                } else if (comp1 != 0) {
//                    return comp1;
//                } else {
//                    return (int) (o1.getWeight() - o2.getWeight());
//                }
//            }
//        });
//        System.out.println(pets);
//    }
}
