package mergeSort.main;

import mergeSort.Helper;
import mergeSort.FileLoader;
import mergeSort.WriterOutput;

// Параметры программы задаются при запуске через аргументы командной строки:
//1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//2. тип данных (-s или -i), обязательный;
//3. имя выходного файла, обязательное;
//4. остальные параметры – имена входных файлов, не менее одного.

public class Main {

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.printHelper();

        String[] links = new String[args.length - 3];
        System.arraycopy(args, 3, links, 0, args.length - 3);
        FileLoader fileLoader = new FileLoader(links);
        WriterOutput writerOutput = new WriterOutput();

        if (args[0].equals("-s") || args[0].equals("-i")) {
            if (args[0].equals("-s")) {
                String[] arr = fileLoader.loadStrings();
                fileLoader.reverseStringArray(arr);
                writerOutput.writeString(arr, args[1]);
            } else if (args[0].equals("-i")) {
                int[] arr = fileLoader.loadIntegers();
                fileLoader.reverseIntArray(arr);
                writerOutput.writeIntegers(arr, args[1]);
            } else {
                helper.printHelper();
            }
        } else if (args[1].equals("-s")) {
            String[] arr = fileLoader.loadStrings();
            if (args[0].equals("-a")) {
                fileLoader.reverseStringArray(arr);
            }
            writerOutput.writeString(arr, args[2]);
        } else if (args[1].equals("-i")) {
            int[] arr = fileLoader.loadIntegers();
            if (args[0].equals("-a")) {
                fileLoader.reverseIntArray(arr);
            }
            writerOutput.writeIntegers(arr, args[2]);
        } else {
            System.out.println("RESTART");
            helper.printHelper();
        }
    }
}