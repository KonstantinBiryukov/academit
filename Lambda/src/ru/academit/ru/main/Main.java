package ru.academit.ru.main;

import ru.academit.ru.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", 23);
        Person person2 = new Person("Alexander", 17);
        Person person3 = new Person("Petr", 26);
        Person person4 = new Person("Nikolai", 14);
        Person person5 = new Person("Irina", 50);
        Person person6 = new Person("Max", 49);
        Person person7 = new Person("Max", 49);
        Person person8 = new Person("Irina", 51);

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);
        //• А) получить список уникальных имен
        //• Б) вывести список уникальных имен в формате - Имена: Иван, Сергей, Петр.
        String uniqueNames = people.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Names: " + uniqueNames);
        System.out.println();

        // В) получить список людей младше 18, посчитать для них средний возраст
        IntStream lessThan18 = people.stream()
                .mapToInt(Person::getAge)
                .filter(x -> x < 18);
        lessThan18.average().ifPresent(System.out::println);
        System.out.println();

        // Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, List<Person>> personsByName = people.stream()
                .collect(Collectors.groupingBy(Person::getName));

        for (Map.Entry<String, List<Person>> item : personsByName.entrySet()) {
            System.out.println(item.getKey());
            for (Person person : item.getValue()) {
                System.out.println(person.getName());
            }
        }
        System.out.println();

        // Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<Person> peopleFrom20to45 =
                people.stream()
                        .filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                        .sorted(Comparator.comparingInt(Person::getAge))
                        .collect(Collectors.toList());

        peopleFrom20to45.forEach(p -> System.out.println(p.getName()));

// Создать бесконечный поток корней чисел. С консоли прочитать число – сколько элементов нужно вычислить,
// затем – распечатать эти элементы
// * Попробовать реализовать бесконечный поток чисел Фиббоначчи
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число - сколько элементов нужно вычислить при создании потока корней чисел...");
        int limit = scanner.nextInt();
        DoubleStream squareRoots = DoubleStream.iterate(0, x -> x + 1).map(Math::sqrt).limit(limit);
        squareRoots.forEach(System.out::println);

        System.out.println();
        System.out.println("fibonacciSequence");
        Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(20)
                .map(s -> s[0]).forEach(s -> System.out.printf("%s | ", s));
    }
}