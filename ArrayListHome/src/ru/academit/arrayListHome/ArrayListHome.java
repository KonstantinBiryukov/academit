//1. Прочитать в список все строки из файла
//2. Есть список из целых чисел. Удалить из него все четные числа. В
//   этой задаче новый список создавать нельзя
//3. Есть список из целых чисел, в нём некоторые числа могут повторяться.
//   Надо создать новый список, в котором будут элементы первого списка в таком же порядке,
//   но без повторений
//   Например, был список [1, 5, 2, 1, 3, 5], должен получиться новый список [1, 5, 2, 3]
package ru.academit.arrayListHome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        // 1
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            System.out.println(list);
        } catch (IOException e) {
            System.out.println("Input-output error" + e.getMessage());
        }

        // 2
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(integers);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                integers.remove(i);
            }
        }
        System.out.println(integers);

        // 3
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 5, 9, 2, 1, 3, 5, 1, 4, 7, 3));
        ArrayList<Integer> newIntList = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            if (newIntList.contains(intList.get(i))) {
                continue;
            }
            newIntList.add(intList.get(i));
        }
        System.out.println(intList);
        System.out.println(newIntList);
    }
}
