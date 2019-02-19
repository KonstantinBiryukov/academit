package mergeSort;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterOutput {
    public void writeString(String[] s, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (String value : s) {
                writer.println(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeIntegers(int[] a, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (int anA : a) {
                writer.println(anA);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}