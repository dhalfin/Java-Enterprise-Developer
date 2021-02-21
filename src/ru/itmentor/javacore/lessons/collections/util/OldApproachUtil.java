package ru.itmentor.javacore.lessons.collections.util;

import ru.itmentor.javacore.lessons.collections.model.Person;
import ru.itmentor.javacore.lessons.collections.model.Pet;
import ru.itmentor.javacore.lessons.collections.model.PetExistsException;
import ru.itmentor.javacore.lessons.collections.model.Sex;

import java.util.*;

public class OldApproachUtil {

    private static Person p1 = new Person(34, Sex.MAN, "Динар");
    private static Person p2 = new Person(14, Sex.WOMAN, "Юлия");
    private static Person p3 = new Person(39, Sex.MAN, "Артем");
    private static Person p4 = new Person(50, Sex.MAN, "Дмитрий");
    private static Person p5 = new Person(15, Sex.WOMAN, "Евгения");


    // Получение начального списка животных
    public static List<Pet> getPets() {

        List<Pet> result = new ArrayList<>();
        result.add(new Pet(001, "Васька", p1, 4.56));
        result.add(new Pet(002, "Пушок", p2, 2.56));
        result.add(new Pet(003, "Шарик", p3, 9.56));
        result.add(new Pet(004, "Тиффи", p2, 6.51));
        result.add(new Pet(005, "Тиффи", p4, 3.06));
        result.add(new Pet(006, "Жесси", p5, 2.96));
        result.add(new Pet(007, "Ферби", p4, 8.56));
        return result;
    }

    // Добавление животного в общий список
    public static List<Pet> addPet(int id, String nickname, Person p, double weight) throws PetExistsException {
        if (!OldApproachUtil.getPets().contains(new Pet(id, nickname, p, weight))) {
            OldApproachUtil.getPets().add(new Pet(id, nickname, p, weight));
        } else {
            throw new PetExistsException(new Pet(id, nickname, p, weight));
        }
        return OldApproachUtil.getPets();
    }

    // Поиск по кличке
    public static List<Pet> filterByNickName(List<Pet> pets, String nickname) {
        List<Pet> result = new ArrayList<>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getNickname().equals(nickname)) {
                result.add(pets.get(i));
            }
        }
        return result;
    }

    //Изменение данных животного по его идентификатору
    public static Map<Integer, Pet> setPetById(Map<Integer, Pet> map, int id, String name, Person person, double weight) {
        Map<Integer, Pet> petMap = new HashMap<>();
        for (int i = 0; i < map.size(); i++) {
            Pet petToUpdate = map.get(id);
            petToUpdate.setNickname(name);
            petToUpdate.setPerson(person);
            petToUpdate.setWeight(weight);
            petMap.put(id, petToUpdate);
        }
        return petMap;
    }

    /*
    вывод на экран списка животных в отсортированном порядке.
     Поля для сортировки – хозяин(имя, по возрастанию),
     если имена хозяев одинаковые - кличка животного. Если и имя
      хозяина и кличка животного одинаковые - раньше вывести животное,
      у которого больше вес
       */
    public void printSortedPets(List<Pet> petsToSort) {
        Collections.sort(petsToSort, new Comparator<Pet>() {
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
        System.out.println(petsToSort);
    }

}