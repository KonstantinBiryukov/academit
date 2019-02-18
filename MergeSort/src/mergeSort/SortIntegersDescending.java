package mergeSort;

public class SortIntegersDescending {

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) { // base method for recursive control
            return array;
        }
        int middleElementPosition = array.length / 2;

        int[] arrayHalf1 = new int[middleElementPosition];
        int[] arrayHalf2;

        if (array.length % 2 == 0) {
            arrayHalf2 = new int[middleElementPosition];
        } else {
            arrayHalf2 = new int[middleElementPosition + 1];
        }

        System.arraycopy(array, 0, arrayHalf1, 0, middleElementPosition);
        System.arraycopy(array, middleElementPosition, arrayHalf2, 0, arrayHalf2.length);

        arrayHalf1 = mergeSort(arrayHalf1);
        arrayHalf2 = mergeSort(arrayHalf2);
        return sortHalves(arrayHalf1, arrayHalf2);
    }

    private int[] sortHalves(int[] arrayHalf1, int[] arrayHalf2) {
        int length = arrayHalf1.length + arrayHalf2.length;
        int[] result = new int[length];

        int leftElement = 0;
        int rightElement = 0;
        int resultElement = 0;

        while (leftElement < arrayHalf1.length || rightElement < arrayHalf2.length) {
            if (leftElement < arrayHalf1.length && rightElement < arrayHalf2.length) {
                if (arrayHalf1[leftElement] < arrayHalf2[rightElement]) {
                    result[resultElement] = arrayHalf1[leftElement];
                    leftElement++;
                } else {
                    result[resultElement] = arrayHalf2[rightElement];
                    rightElement++;
                }
            } else if (leftElement < arrayHalf1.length) {
                result[resultElement] = arrayHalf1[leftElement];
                leftElement++;
            } else if (rightElement < arrayHalf2.length) {
                result[resultElement] = arrayHalf2[rightElement];
                rightElement++;
            }
            resultElement++;
        }
        return result;
    }
}