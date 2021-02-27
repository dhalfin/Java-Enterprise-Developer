package ru.itmentor.javacore.lessons.collections;

import java.util.Comparator;
import java.util.Objects;

public class Pet implements Comparable<Pet> {

    private int id;
    private String nickname;
    private Person person;
    private double weight;

    public Pet(int id, String nickname, Person person, double weight) {
        this.id = id;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Double.compare(pet.weight, weight) == 0 &&
                nickname.equals(pet.nickname) &&
                person.equals(pet.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, person, weight);
    }

    @Override
    public int compareTo(Pet pet) {
        int value = 0;
        if (this.person.compareTo(pet.person) > 0) {
            value = 1;
        } else if (this.person.compareTo(pet.person) < 0) {
            value = -1;
        } else {
            if (this.nickname.compareTo(pet.nickname) > 0) {
                value = 1;
            } else if (this.nickname.compareTo(pet.nickname) < 0) {
                value = -1;
            } else {
                value = Double.compare(this.weight, pet.weight);
            }
        }
        return value;
    }

//    public static class personNameComparator implements Comparator<Pet> {
//        @Override
//        public int compare(Pet o1, Pet o2) {
//            return o1.person.getName().compareTo(o2.person.getName());
//        }
//    }
//
//    public static class petNameComparator implements Comparator<Pet> {
//        @Override
//        public int compare(Pet o1, Pet o2) {
//            return o1.nickname.compareTo(o2.nickname);
//        }
//    }
//
//    public static class weightPetComparator implements Comparator<Pet> {
//        @Override
//        public int compare(Pet o1, Pet o2) {
//            return (int) (o1.getWeight() - o2.getWeight());
//        }
//    }

    @Override
    public String toString() {
        return "Pet {" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }
}