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
        if (args.length != 1) {
            System.out.println("We should have the only one FileInputStream in the arguments...");
            return;
        } else {
            try (Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
                ArrayList<String> list = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    list.add(scanner.nextLine());
                }
                System.out.println(list);
            } catch (IOException e) {
                System.out.println("Input-output error" + e.getMessage());
            }
        }

        // 2
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(-2, -1, 0, 1, 2, 32, 34, 36, 33, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(integers);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                integers.remove(i);
                i--;
            }
        }
        System.out.println(integers);

        // 3
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 5, 9, 2, 1, 3, 5, 1, 4, 7, 3));
        ArrayList<Integer> newIntList = new ArrayList<>();
        for (Integer intListElement : intList) {
            if (newIntList.contains(intListElement)) {
                continue;
            }
            newIntList.add(intListElement);
        }
        System.out.println(intList);
        System.out.println(newIntList);
    }
}
