package ru.academit.ru;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
//
//    @Override
//    public String toString() {
//        return String.format("Person{name='%s', age=%d}", name, age);
//    }


}
