package mergeSort;

import mergeSort.main.Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoadClasses {
    private String[] linksArray;
    private String[] s;

    public LoadClasses(String[] linksArray) {
        this.linksArray = linksArray;
    }

    public int[] loadIntegers(Main.DataType dataType) {
        StringBuilder fileContent = new StringBuilder();
        for (int i = 0; i < linksArray.length; i++) {
            try (Scanner scanner = new Scanner(new FileReader(linksArray[i]))) {
                while (scanner.hasNextLine()) {
                    fileContent.append(scanner.nextLine()).append(", ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        s = fileContent.toString().split(", ");
        int[] integers = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            integers[i] = Integer.parseInt(s[i]);
        }
        SortIntegersDescending sortIntegersDescending = new SortIntegersDescending();
        return sortIntegersDescending.mergeSort(integers);
    }

    public String[] loadStrings() {

        StringBuilder fileContent = new StringBuilder();
        for (int i = 0; i < linksArray.length; i++) {
            try (Scanner scanner = new Scanner(new FileReader(linksArray[i]))) {
                while (scanner.hasNextLine()) {
                    fileContent.append(scanner.nextLine()).append(", ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        s = fileContent.toString().split(", ");
        String[] strings = new String[s.length];
        SortStringsDescending sortStringsDescending = new SortStringsDescending();
        return sortStringsDescending.mergeSort(s);
    }
}