package ru.academit.arrayList.main;

import ru.academit.arrayList.ArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;
//@Test

// 1 size
// 2 isEmpty
// 3 contains
// 4 iterator
// 5 toArray
// 6 toArray
// 7 add
// 8 remove
// 9 containsAll
// 10 addAll
// 11 addAll
// 12 removeAll
// 13 retainAll
// 14 clear
// 15 get
// 16 set
// 17 add
// 18 remove
// 19 indexOf
// 20 lastIndexOf
// 21 increaseCapacity
// 22 ensureCapacity
// 23 trimToSize

public class Main {
    public static void main(String[] args) {

        ArrayList<String> stringList = new ArrayList<>(15);
        stringList.add("FFFF");
        stringList.add("something");
        stringList.add("aaaaaa");
        stringList.add("???");
        stringList.add("cccccc");
        stringList.add(null);
        stringList.add("NNZ");

        ArrayList<Integer> intList = new ArrayList<>(1);
        intList.add(10);
        intList.add(66);
        intList.add(777);
        intList.add(223);
        intList.add(3);
        intList.add(0);
        intList.add(-5);
        intList.add(null);
        intList.add(444);

        String[] sss = stringList.toArray(new String[stringList.size()]);
        Integer[] aaa = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(sss));
        System.out.println(Arrays.toString(aaa));

        System.out.println();
        System.out.println("SIZE");
        System.out.println(stringList.size());
        System.out.println(intList.size());

        System.out.println();
        System.out.println("IS_EMPTY");
        System.out.println(stringList.isEmpty());
        System.out.println(intList.isEmpty());

        System.out.println();
        System.out.println("CONTAINS");
        System.out.println(Arrays.toString(sss));
        System.out.println(Arrays.toString(aaa));
        System.out.println(stringList.contains("3"));
        System.out.println(intList.contains(223));

        System.out.println();
        System.out.println("CONTAINS_ALL");
        ArrayList<String> stringList2 = new ArrayList<>(1);
        stringList2.add("FFFF");
        stringList2.add("aaaaaa");
        stringList2.add(null);
        System.out.println(stringList.containsAll(stringList2));

        System.out.println();
        System.out.println("ADD");
        System.out.println(stringList.add("NEW"));
        System.out.println(intList.add(1));
        String[] sss2 = stringList.toArray(new String[stringList.size()]);
        Integer[] aaa2 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(sss2));
        System.out.println(Arrays.toString(aaa2));

        System.out.println();
        System.out.println("REMOVE_BY_DATA");
        System.out.println(stringList.remove("S"));
        System.out.println(intList.remove((Integer) 223));
        String[] sss3 = stringList.toArray(new String[stringList.size()]);
        Integer[] aaa3 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(sss3));
        System.out.println(Arrays.toString(aaa3));

        System.out.println();
        System.out.println("REMOVE_BY_INDEX");
        System.out.println(stringList.size());
        System.out.println(stringList.remove(4));
        System.out.println(intList.remove(7));
        String[] sss4 = stringList.toArray(new String[stringList.size()]);
        Integer[] aaa4 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(sss4));
        System.out.println(Arrays.toString(aaa4));

        System.out.println();
        System.out.println("ADD_BY_INDEX");
        System.out.println(stringList.size());
        stringList.add(7, "A_LIST");
        intList.add(7, -19);
        String[] s4 = stringList.toArray(new String[stringList.size()]);
        Integer[] a4 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(s4));
        System.out.println(Arrays.toString(a4));

        System.out.println();
        System.out.println("INDEX_OF");
        System.out.println(stringList.indexOf("???"));
        System.out.println(stringList.indexOf("A_LIST"));
        System.out.println(intList.indexOf(-19));
        System.out.println(intList.indexOf(10));

        System.out.println(stringList.add("A_LIST"));
        System.out.println(intList.add(-19));
        System.out.println();

        String[] s5 = stringList.toArray(new String[stringList.size()]);
        Integer[] a5 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(s5));
        System.out.println(Arrays.toString(a5));

        System.out.println();
        System.out.println("LAST_INDEX_OF");
        System.out.println(stringList.lastIndexOf("FF2FF"));
        System.out.println(stringList.lastIndexOf("A_LIST"));
        System.out.println(intList.lastIndexOf(-19));
        System.out.println(intList.lastIndexOf(11));
        System.out.println(intList.lastIndexOf(10));

        System.out.println();
        String[] s6 = stringList.toArray(new String[stringList.size()]);
        Integer[] a6 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(s6));
        System.out.println(Arrays.toString(a6));

        System.out.println();
        System.out.println("GET/SET");
        System.out.println(stringList.get(5));
        System.out.println(intList.get(7));

        System.out.println(stringList.set(5, "SET"));
        System.out.println(intList.set(7, 2018));
        System.out.println(stringList.get(5));
        System.out.println(intList.get(7));

        System.out.println();
        System.out.println("ADD_ALL");
        String[] sss33 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(sss33));
        ArrayList<String> newCollection = new ArrayList<>(5);
        newCollection.add("smth");
        newCollection.add("AAA");
        newCollection.add("ZZZ");

        String[] newCol = newCollection.toArray(new String[newCollection.size()]);
        System.out.println(Arrays.toString(newCol));

        stringList.addAll(newCollection);
        String[] addAll = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(addAll));

        System.out.println();
        System.out.println("ADD_ALL_FROM_INDEX");
        ArrayList<String> newCollection2 = new ArrayList<>(10);
        newCollection2.add("!___!");
        newCollection2.add(":)");
        newCollection2.add(":<");
        newCollection2.add("aaaaaa");
        newCollection2.add(":<");
        stringList.add("aaaaaa");

        String[] arrr = stringList.toArray(new String[stringList.size()]);
        String[] arrr2 = newCollection2.toArray(new String[newCollection2.size()]);
        System.out.println(Arrays.toString(arrr));
        System.out.println(Arrays.toString(arrr2));

        System.out.println(stringList.size());
        stringList.addAll(13, newCollection2);
        String[] addAll2 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(addAll2));

        System.out.println();
        System.out.println("REMOVE_ALL");
        ArrayList<String> newCollection5 = new ArrayList<>(10);
        newCollection5.add("FFFF");
        newCollection5.add("SET");
        newCollection5.add(":<");

        String[] test1 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(test1));
        String[] arrr3 = newCollection5.toArray(new String[newCollection5.size()]);
        System.out.println(Arrays.toString(arrr3));
        System.out.println(stringList.removeAll(newCollection5));

        String[] test2 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(test2));

        System.out.println();
        System.out.println("RETAIN_ALL");
        String[] test3 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(test3));
        ArrayList<String> newCollection3 = new ArrayList<>(10);
        newCollection3.add("???");
        newCollection3.add("AAA");
        newCollection3.add("YYY");
        newCollection3.add("NEW");
        String[] ar2 = newCollection3.toArray(new String[newCollection3.size()]);
        System.out.println(Arrays.toString(ar2));
        System.out.println(stringList.retainAll(newCollection3));
        String[] test4 = stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(test4));

        System.out.println();
        System.out.println(Arrays.toString(test4));
        Integer[] test5 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(test5));

        System.out.println();
        System.out.println("ENSURE_CAPACITY");
        System.out.println(intList.size());
        intList.ensureCapacity(20);

        System.out.println();
        System.out.println("CLEAR");
        stringList.clear();
        intList.clear();
        String[] clear1 = stringList.toArray(new String[stringList.size()]);
        Integer[] clear2 = intList.toArray(new Integer[intList.size()]);
        System.out.println(Arrays.toString(clear1));
        System.out.println(Arrays.toString(clear2));
        System.out.println(stringList.isEmpty());
    }
}
