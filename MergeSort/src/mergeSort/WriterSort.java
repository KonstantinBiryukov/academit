package mergeSort;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterSort {
//    public void writeString(String[] s) {
//        try (PrintWriter writer = new PrintWriter("output2.txt")) {
//            for (String value : s) {
//                writer.println(value);
//            }
//            System.out.println(Arrays.toString(s));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void write(Object[] a) {
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (Object anA : a) {
                writer.println(anA);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}