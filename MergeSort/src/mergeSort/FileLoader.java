package mergeSort;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileLoader {
    private String[] linksArray;
    private String[] s;

    public FileLoader(String[] linksArray) {
        this.linksArray = linksArray;
    }

    public int[] loadIntegers() {
        StringBuilder fileContent = new StringBuilder();
        for (String aLinksArray : linksArray) {
            try (Scanner scanner = new Scanner(new FileReader(aLinksArray))) {
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
        IntegersSorting integersSorting = new IntegersSorting();
        return integersSorting.mergeSort(integers);
    }

    public String[] loadStrings() {
        StringBuilder fileContent = new StringBuilder();
        for (String aLinksArray : linksArray) {
            try (Scanner scanner = new Scanner(new FileReader(aLinksArray))) {
                while (scanner.hasNextLine()) {
                    fileContent.append(scanner.nextLine()).append(", ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        s = fileContent.toString().split(", ");
        StringsSorting stringsSorting = new StringsSorting();
        return stringsSorting.mergeSort(s);
    }

    public void reverseIntArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int container = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = container;
        }
    }

    public void reverseStringArray(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String container = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = container;
        }
    }
}
