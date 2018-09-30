package ru.academit.csv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream
                ("/Users/konstantinbiriukov/Desktop/csvFile.csv"))) {

        }

        try (PrintWriter writer = new PrintWriter("/Users/konstantinbiriukov/Desktop/csvFileHtml.html")){
            writer.println("ok");
        }
    }
}
