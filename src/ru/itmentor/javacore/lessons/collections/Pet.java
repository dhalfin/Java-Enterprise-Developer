package ru.itmentor.javacore.lessons.collections;

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
    public int compareTo(Pet pet) {
        int value = 0;
        if (person.compareTo(pet.person) > 0) {
            value = 1;
        } else if (person.compareTo(pet.person) < 0) {
            value = -1;
        } else {
            if (nickname.compareTo(pet.nickname) > 0) {
                value = 1;
            } else if (nickname.compareTo(pet.nickname) < 0) {
                value = -1;
            } else {
                value = Double.compare(weight, pet.weight);
            }
        }
        return value;

//        int comp = person.getName().compareTo(pet.getPerson().getName());
//        int comp1 = nickname.compareTo(pet.getNickname());
//        if (comp != 0) {
//            return comp;
//        } else if (comp1 != 0) {
//            return comp1;
//        } else {
//            return (int) (weight - pet.getWeight());
//        }
        //return nickname.compareTo(pet.getNickname());
    }

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