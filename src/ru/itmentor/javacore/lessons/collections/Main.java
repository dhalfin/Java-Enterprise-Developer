package ru.itmentor.javacore.lessons.collections;

import ru.itmentor.javacore.lessons.collections.model.Person;
import ru.itmentor.javacore.lessons.collections.model.Pet;
import ru.itmentor.javacore.lessons.collections.model.PetExistsException;
import ru.itmentor.javacore.lessons.collections.model.Sex;
import ru.itmentor.javacore.lessons.collections.util.OldApproachUtil;
import ru.itmentor.javacore.lessons.collections.util.StreamAPIUtil;

import java.util.List;

public class Main {


    public static Person p1 = new Person(34, Sex.MAN, "Динар");
    public static Person p2 = new Person(14, Sex.WOMAN, "Юлия");
    public static Person p3 = new Person(39, Sex.MAN, "Артем");
    public static Person p4 = new Person(50, Sex.MAN, "Дмитрий");
    public static Person p5 = new Person(15, Sex.WOMAN, "Евгения");


    public static void main(String[] args) throws PetExistsException {

        //List<Pet> pets = OldApproachUtil.getPets();
        List<Pet> pets = StreamAPIUtil.getPets();

        //Filter
        //List<Pet> petByNick = OldApproachUtil.filterByNickName(pets, "Тиффи");
        List<Pet> petByNick = StreamAPIUtil.filterByNickName(pets, "Тиффи");
        StreamAPIUtil.printPets(petByNick);

        //Adding
        List<Pet> newList = OldApproachUtil.addPet(004, "Тиффи", p2, 6.51);


    }

}
