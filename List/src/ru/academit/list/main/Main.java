package ru.academit.list.main;

import ru.academit.list.SinglyLinkedList;

//@test
public class Main {
    public static void main(String[] args) {

        System.out.println("GET_FIRST");
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addFirst(10);
        System.out.println(list1.getFirst());

        list1.addFirst(20);
        System.out.println(list1.getFirst());

        list1.addFirst(30);
        System.out.println(list1.getFirst());

        list1.addFirst(40);
        System.out.println(list1.getFirst());
        list1.addFirst(50);
        System.out.println(list1.getFirst());
        list1.addFirst(60);
        System.out.println(list1.getFirst());
        list1.addFirst(70);
        System.out.println(list1.getFirst());
        list1.addFirst(80);
        System.out.println(list1.getFirst());

        System.out.println();
        System.out.println("GET_COUNT, REMOVE_FIRST");
        System.out.println(list1.getCount());
        System.out.println(list1.removeFirst());
        System.out.println(list1.getFirst());
        System.out.println();

        System.out.println();
        System.out.println("GET/SET_DATA_BY_INDEX");
        System.out.println(list1.getDataByIndex(4));
        System.out.println(list1.setDataByIndex(66, 4));
        System.out.println(list1.getDataByIndex(4));

        System.out.println();
        System.out.println("ADD/REMOVE_BY_INDEX");
        list1.addByIndex(100, 2);
        list1.removeByIndex(2);

        System.out.println();
        System.out.println("REMOVE_BY_DATA");
        System.out.println(list1.getDataByIndex(1));
        System.out.println(list1.removeByData(55));
        System.out.println("NULL");
        list1.addFirst(null);
        list1.addFirst(null);
        list1.addFirst(null);

        System.out.println("RRRRR");
        System.out.println(list1.removeByData(null));
        System.out.println(list1.getDataByIndex(1));
        System.out.println(list1.removeByData(70));
        System.out.println(list1.getDataByIndex(3));

        System.out.println();
        System.out.println("COPY_LIST");
        SinglyLinkedList<Integer> t1 = list1.copyList();
        System.out.println(list1.removeByIndex(3));
        System.out.println(list1.removeByIndex(0));

        System.out.println();
        System.out.println(list1.getDataByIndex(0));
        System.out.println(list1.getDataByIndex(1));
        System.out.println(list1.getDataByIndex(2));
        System.out.println(list1.getDataByIndex(3));
        System.out.println(list1.getDataByIndex(4));
        System.out.println(list1.getDataByIndex(5));
        System.out.println(list1.getDataByIndex(6));
        //  System.out.println(list1.getDataByIndex(7));
        System.out.println("count: " + list1.getCount());

        System.out.println();
        System.out.println(t1.getDataByIndex(0));
        System.out.println(t1.getDataByIndex(1));
        System.out.println(t1.getDataByIndex(2));
        System.out.println(t1.getDataByIndex(3));
        System.out.println(t1.getDataByIndex(4));
        System.out.println(t1.getDataByIndex(5));
        System.out.println(t1.getDataByIndex(6));
        System.out.println(t1.getDataByIndex(7));
        System.out.println(t1.getDataByIndex(8));
        //   System.out.println(t1.getDataByIndex(9));
        System.out.println("count: " + t1.getCount());

        System.out.println();
        System.out.println("REVERSE_LIST");

        SinglyLinkedList<String> test2 = new SinglyLinkedList<>();
        test2.addFirst("c");
        test2.addFirst("b");
        test2.addFirst("a");

        System.out.println(test2.getDataByIndex(0));
        System.out.println(test2.getDataByIndex(1));
        System.out.println(test2.getDataByIndex(2));

        test2.reverseList();

        System.out.println();
        System.out.println(test2.getDataByIndex(0));
        System.out.println(test2.getDataByIndex(1));
        System.out.println(test2.getDataByIndex(2));

        System.out.println();
        System.out.println("COPY_LIST");

        SinglyLinkedList<String> test3 = new SinglyLinkedList<>();
        test3.addFirst("S");
        test3.addFirst("F");

        System.out.println(test3.getDataByIndex(0));
        System.out.println(test3.getDataByIndex(1));
        System.out.println();

        SinglyLinkedList<String> t4 = test3.copyList();
        t4.addFirst("555");
        t4.addFirst("544");
        System.out.println(t4.getDataByIndex(0));
        System.out.println(t4.getDataByIndex(1));
        System.out.println(t4.getDataByIndex(2));
        System.out.println(t4.getDataByIndex(3));

        System.out.println();
        System.out.println("COPY_EMPTY_LIST");
        SinglyLinkedList<String> test4 = new SinglyLinkedList<>();
        SinglyLinkedList<String> test5 = test4.copyList();
        test5.addFirst("555");
        test5.addFirst("544");
        System.out.println(test5.getDataByIndex(0));
        System.out.println(test5.getDataByIndex(1));

        System.out.println();
        System.out.println("REVERSE_EMPTY_LIST");
        SinglyLinkedList<String> test6 = new SinglyLinkedList<>();
        test6.reverseList();
        test6.addFirst("c");
        test6.addFirst("b");
        test6.addFirst(null);
        System.out.println(test6.getDataByIndex(0));
        System.out.println(test6.getDataByIndex(1));
        System.out.println(test6.getDataByIndex(2));

        System.out.println();
        test6.addByIndex("NEW", 0);
        System.out.println(test6.getDataByIndex(0));
        System.out.println(test6.getDataByIndex(1));
        System.out.println(test6.getDataByIndex(2));
        System.out.println(test6.getDataByIndex(3));

        System.out.println();
        System.out.println(test6.removeByIndex(1));
        System.out.println();
        System.out.println(test6.getDataByIndex(0));
        System.out.println(test6.getDataByIndex(1));
        System.out.println(test6.getDataByIndex(2));
    }
}