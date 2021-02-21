package ru.itmentor.javacore.lessons.collections.util;

import ru.itmentor.javacore.lessons.collections.model.Person;
import ru.itmentor.javacore.lessons.collections.model.Pet;
import ru.itmentor.javacore.lessons.collections.model.PetExistsException;
import ru.itmentor.javacore.lessons.collections.model.Sex;

import java.util.Collections;;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIUtil {

    private static Person p1 = new Person(34, Sex.MAN, "Динар");
    private static Person p2 = new Person(14, Sex.WOMAN, "Юлия");
    private static Person p3 = new Person(39, Sex.MAN, "Артем");
    private static Person p4 = new Person(50, Sex.MAN, "Дмитрий");
    private static Person p5 = new Person(15, Sex.WOMAN, "Евгения");


    // Получение начального списка животных
    public static List<Pet> getPets() {
        return List.of(
                new Pet(001,"Васька", p1, 4.56),
                new Pet(002,"Пушок", p2, 2.56),
                new Pet(003,"Шарик", p3, 9.56),
                new Pet(004,"Тиффи", p4, 3.06),
                new Pet(005,"Жесси", p5, 2.96),
                new Pet(006,"Ферби", p4, 8.56)
        );
    }

    // Добавление животного в общий список
    public static List<Pet> addPets(int id, String nickname, Person p, double weight) throws PetExistsException {
        if (!StreamAPIUtil.getPets().contains(new Pet(id, nickname, p, weight))) {
            StreamAPIUtil.getPets();
            return List.of(
                    new Pet(id, nickname, p, weight)
            );
        } else {
            throw new PetExistsException(new Pet(id, nickname, p, weight));
        }
    }

    // Поиск по кличке
    public static List<Pet> filterByNickName(List<Pet> pets, String nickname) {
        return pets.stream()
                .filter(pet -> pet.getNickname().equals(nickname))
                .collect(Collectors.toList());
    }

    // Вывод в консоль
    public static void printPets(List<Pet> pets) {
        pets.forEach(System.out::println);
    }

    /*
    вывод на экран списка животных в отсортированном порядке.
     Поля для сортировки – хозяин(имя, по возрастанию),
     если имена хозяев одинаковые - кличка животного. Если и имя
      хозяина и кличка животного одинаковые - раньше вывести животное,
      у которого больше вес
       */
    public void printSortedPets(List<Pet> petsToSort) {
        Collections.sort(petsToSort, (o1, o2) -> {
            int comp = o1.getPerson().getName().compareTo(o2.getPerson().getName());
            int comp1 = o1.getNickname().compareTo(o2.getNickname());
            if (comp != 0) {
                return comp;
            } else if (comp1 != 0) {
                return comp1;
            } else {
                return (int) (o1.getWeight() - o2.getWeight());
            }
        });
        System.out.println(petsToSort);
    }
}
