package mergeSort.main;

import mergeSort.Helper;
import mergeSort.LoadClasses;
import mergeSort.WriterSort;

// Параметры программы задаются при запуске через аргументы командной строки:
//1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//2. тип данных (-s или -i), обязательный;
//3. имя выходного файла, обязательное;
//4. остальные параметры – имена входных файлов, не менее одного.

public class Main {
    public enum Order {
        A, D
    }

    public enum DataType {
        S, I
    }

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.printHelper();
        Order order = null;
        DataType dataType = null;

        switch (args[0]) {
            case "-a":  // order
                order = Order.A; // mergeSortAscending
                break;
            case "-d":
                order = Order.D; // mergeSortDescending
                break;
            case "-i":
            case "-s":
                args[0] = "-a";
                order = Order.A;
                System.arraycopy(args, 0, args, 1, args.length);
                break;
            default:
                System.out.println("1st argument should be either \"-a\", sort in ascending order, or \"-d\" - sort in descending order. Please specify the mode");
                break;
        }

        String[] links = new String[args.length - 3];
        for (int i = 0; i < args.length - 3; i++) {
            links[i] = args[i + 3];
        }
        LoadClasses loadClasses = new LoadClasses(links);
        WriterSort writerSort = new WriterSort();

        // data_type
        if (args[1].equals("-s") || args[1].equals("-i")) {
            String[] s = loadClasses.loadStrings();
            writerSort.write(s);
       // }
//        else if (args[1].equals("-i")) {
//            int[] i = loadClasses.loadIntegers(DataType.I);
//            writerSort.write(i);
        } else {
            System.out.println("2nd argument should be either \"-s\" for strings, or \"-i\" for integers. Please specify the mode");
        }
    }
}

