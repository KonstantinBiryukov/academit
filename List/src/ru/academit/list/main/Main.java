package ru.academit.list.main;

import ru.academit.list.ListItem;
import ru.academit.list.SinglyLinkedList;

//@test
public class Main {
    public static void main(String[] args) {
        ListItem<Integer> node1 = new ListItem<>(5);

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>(node1);
        System.out.println(list1.getFirst());
        list1.addFirst(10);
        System.out.println(list1.getFirst());

        list1.addFirst(20);
        System.out.println(list1.getFirst());

        list1.addFirst(30);
        System.out.println(list1.getFirst());

        list1.addFirst(40);
        System.out.println(list1.getFirst());
        list1.addFirst(50);
        list1.addFirst(60);
        list1.addFirst(70);
        list1.addFirst(80);

        System.out.println(list1.getCount());

        System.out.println(list1.removeFirst());
        System.out.println(list1.getFirst());

        System.out.println();
        System.out.println(list1.getDataByIndex(4));
        System.out.println(list1.setDataByIndex(66, 4));
        System.out.println(list1.getDataByIndex(4));

        System.out.println();
        list1.addByIndex(100, 2);
        list1.removeByIndex(2);

        System.out.println(list1.removeByData(55));
        System.out.println(list1.getDataByIndex(1));

        System.out.println(list1.removeByData(70));
        System.out.println(list1.getDataByIndex(1));
        System.out.println();

        SinglyLinkedList<Integer> t1 = list1.copyList();
        System.out.println(list1.removeByIndex(3));

        System.out.println();
        System.out.println(list1.getDataByIndex(1));
        System.out.println(list1.getDataByIndex(2));
        System.out.println(list1.getDataByIndex(3));
        System.out.println(list1.getDataByIndex(4));
        System.out.println(list1.getDataByIndex(5));
        System.out.println(list1.getDataByIndex(6));
        System.out.println(list1.getDataByIndex(7));
        System.out.println("count: " + list1.getCount());

        System.out.println();
        System.out.println(t1.getDataByIndex(1));
        System.out.println(t1.getDataByIndex(2));
        System.out.println(t1.getDataByIndex(3));
        System.out.println(t1.getDataByIndex(4));
        System.out.println(t1.getDataByIndex(5));
        System.out.println(t1.getDataByIndex(6));
        System.out.println(t1.getDataByIndex(7));
        System.out.println("count: " + t1.getCount());

        System.out.println();
        System.out.println();
        System.out.println();

        ListItem<String> node2 = new ListItem<>("c");
        SinglyLinkedList<String> test2 = new SinglyLinkedList<>(node2);
        test2.addFirst("b");
        test2.addFirst("a");

        System.out.println(test2.getDataByIndex(1));
        System.out.println(test2.getDataByIndex(2));
        System.out.println(test2.getDataByIndex(3));

        test2.reverseList();
        System.out.println();

        System.out.println(test2.getDataByIndex(1));
        System.out.println(test2.getDataByIndex(2));
        System.out.println(test2.getDataByIndex(3));
    }
}