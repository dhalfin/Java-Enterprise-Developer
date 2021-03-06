package ru.itmentor.javacore.lessons.petstreamapi;

public class Person {

    private final int age;
    private final Sex sex;
    private final String name;

    public Person(int age, Sex sex, String name) {

        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }
}

