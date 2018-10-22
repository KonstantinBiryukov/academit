package ru.academit.CSV;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {

    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter("/Users/konstantinbiriukov/Desktop/htmlFile.html");
             Scanner scanner = new Scanner(new FileInputStream
                     ("/Users/konstantinbiriukov/Desktop/csvFile.csv"))) {
            writer.println("<table border=\"1\"");
            writer.print("<tr><td>");

            boolean isPlainTextInsideTableDetailModeON = false;
            boolean isNewLine = false;

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (isNewLine) {
                    writer.print("<br/><tr><td>");
                }

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    char comma = ',';
                    char quote = '"';

                    if (c == quote && s.charAt(i - 1) == comma) {
                        isPlainTextInsideTableDetailModeON = true;
                        continue;
                    } else if (c == comma && s.charAt(i - 1) == quote) {
                        isPlainTextInsideTableDetailModeON = false;
                    } else if (c == quote && isPlainTextInsideTableDetailModeON) {
                        isPlainTextInsideTableDetailModeON = false;
                        continue;
                    } else if (c == quote && s.charAt(i - 1) == quote) {
                        isPlainTextInsideTableDetailModeON = true;
                    }

                    if (c == comma && s.charAt(i - 1) == quote && s.charAt(i - 2) == quote && s.charAt(i - 3) != quote) {
                        writer.print(c);
                    } else if (c == comma) {
                        writer.print("</td> <td>");
                    } else {
                        writer.print(c);
                    }
                }
                if (isPlainTextInsideTableDetailModeON) {
                    writer.print("<br/>");
                } else {
                    writer.print("</td></tr>");
                    isNewLine = true;
                }
            }
            writer.println("</table>");
        }
    }
}