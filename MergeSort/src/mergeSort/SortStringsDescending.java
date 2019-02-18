package mergeSort;

public class SortStringsDescending {

    public String[] mergeSort(String[] array) {
        if (array.length <= 1) { // base method for recursive control
            return array;
        }
        int middleElementPosition = array.length / 2;

        String[] arrayHalf1 = new String[middleElementPosition];
        String[] arrayHalf2;

        if (array.length % 2 == 0) {
            arrayHalf2 = new String[middleElementPosition];
        } else {
            arrayHalf2 = new String[middleElementPosition + 1];
        }

        System.arraycopy(array, 0, arrayHalf1, 0, middleElementPosition);
        System.arraycopy(array, middleElementPosition, arrayHalf2, 0, arrayHalf2.length);

        arrayHalf1 = mergeSort(arrayHalf1);
        arrayHalf2 = mergeSort(arrayHalf2);
        return sortHalves(arrayHalf1, arrayHalf2);
    }

    public String[] sortHalves(String[] arrayHalf1, String[] arrayHalf2) {
        int length = arrayHalf1.length + arrayHalf2.length;
        String[] result = new String[length];
        int leftElement = 0;
        int rightElement = 0;

        for (int i = 0; i < result.length; i++) {
            if (rightElement >= arrayHalf2.length || (leftElement < arrayHalf1.length
                    && arrayHalf1[leftElement].compareToIgnoreCase(arrayHalf2[rightElement]) < 0)) {
                result[i] = arrayHalf1[leftElement];
                leftElement++;
            } else {
                result[i] = arrayHalf2[rightElement];
                rightElement++;
            }
        }
        return result;
    }
}

