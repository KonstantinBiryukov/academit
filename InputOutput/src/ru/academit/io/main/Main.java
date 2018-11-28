package ru.academit.io.main;

import java.io.*;

// Задача 1: Побайтово скопировать файл
//• Использовать буферизованные байтовые потоки, использовать цикл при чтении
// Задача 2
//• Создать файл и записать в него 100 строк вида «Строка 1», «Строка 2» и т.д. до «Строка 100»
//• Записать в файл еще несколько произвольных строк при помощи методов printf(), print(), println()
//• Использовать PrintWriter

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream inputFromJpg =
                     new BufferedInputStream(new FileInputStream("/Users/konstantinbiriukov/Desktop/ticket.jpg"));
             BufferedOutputStream outputToJpg =
                     new BufferedOutputStream(new FileOutputStream("/Users/konstantinbiriukov/Desktop/ticketNEW.jpg"))) {
            int read;
            int off = 0;
            int size = inputFromJpg.available();
            byte[] res = new byte[size + 1];
            while ((read = inputFromJpg.read(res, off, res.length - off)) != -1) {
                off += read;
            }
            outputToJpg.write(res, 0, off);
        }

        try (PrintWriter writer = new PrintWriter("/Users/konstantinbiriukov/Desktop/output.txt")) {
            for (int i = 1; i <= 100; i++) {
                writer.printf("Строка %d", i);
                writer.println();
            }
            writer.printf("i = %s", "lineNumber");
            writer.println();
            writer.print("The last line");
        }
    }
}
