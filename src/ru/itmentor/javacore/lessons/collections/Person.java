package ru.itmentor.javacore.lessons.collections;

public class Person implements Comparable<Person> {

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

    @Override
    public int compareTo(Person person) {
        int value = 0;
        if (name.compareTo(person.name) > 0) {
            value = 1;
        } else if (name.compareTo(person.name) < 0) {
            value = -1;
        } else {
            if (age > person.age) {
                value = 1;
            } else if (age < person.age) {
                value = -1;
            }
        }
        return value;
    }
}

