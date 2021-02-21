package ru.itmentor.javacore.lessons.petstreamapi;

public class Main {

    public static void main(String[] args) throws PetExistsException {

        Person p1 = new Person(34, Sex.MAN, "Динар");
        Person p2 = new Person(14, Sex.WOMAN, "Юлия");
        Person p3 = new Person(39, Sex.MAN, "Артем");
        Person p4 = new Person(50, Sex.MAN, "Дмитрий");
        Person p5 = new Person(15, Sex.WOMAN, "Евгения");
        PetRecordSystem prs = new PetRecordSystem();
        prs.addPet(new Pet(1, "Васька", p1, 4.56));
        prs.addPet(new Pet(2, "Пушок", p2, 2.56));
        prs.addPet(new Pet(3, "Шарик", p3, 9.56));
        prs.addPet(new Pet(4, "Тиффи", p2, 6.51));
        prs.addPet(new Pet(5, "Тиффи", p4, 3.06));
        prs.addPet(new Pet(6, "Жесси", p5, 2.96));
        prs.addPet(new Pet(7, "Ферби", p4, 8.56));

        System.out.println(prs.getAllPetsByName("Тиффи"));
        prs.printAllPetsSorted();
    }
}
