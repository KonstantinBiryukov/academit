package mergeSort;

public class Helper {

    public void printHelper() {
        System.out.println("Welcome to merge_sort!" + System.lineSeparator() +
                "Use 4 arguments(special set of keys) to choose appropriate settings: " + System.lineSeparator() +
                "* 1st arguments is optional, 2-4+ arguments are required; whitespace is a symbol you should use to separate arguments;"
                + System.lineSeparator() + "1. sort mode: \"-a\" = ascending order, \"-d\" = descending order. " +
                "Ascending order will be chosen as a default argument if this key is not specified;" + System.lineSeparator() +
                "2. type of data: \"-s\" = strings, \"-i\" = integers;" + System.lineSeparator() +
                "3. a name of output file, a file will be a final result that contains all sorted data;" + System.lineSeparator() +
                "4+. names of all input files. The number of arguments should be equal to 1 or greater. " + System.lineSeparator() +
                "These are the files a program will be working with, be sure it contains a type of data you've specified with a 2nd key;"
                + System.lineSeparator() + System.lineSeparator() +
                "If something goes wrong you would see this -help mode again, if something goes 'too wrong', too far from"
                + System.lineSeparator() + "any expected behaviour, a console app will be crushed, try again and be sure that your data is valid, "
                + System.lineSeparator() + "all paths are correct and all required keys are specified according to this help mode."
                + System.lineSeparator() + "Example: sort-it.exe -i -a out.txt in.txt" + System.lineSeparator() +
                "_____________________________________" + System.lineSeparator()
        );
    }
}
