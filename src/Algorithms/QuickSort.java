package Algorithms;

import java.util.Arrays;

public class QuickSort {

    private static void swapValuesHelper(int[] array, int index1, int index2) {
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int x = pivotIndex + 1; x <= endIndex; ++x) {
            if (array[x] < array[swapIndex]) {
                swapIndex++;
                swapValuesHelper(array, swapIndex, x);
            }
        }

        swapValuesHelper(array, swapIndex, endIndex);

        return swapIndex;
    }

    private static void quickSortHelper(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int pivotIndex = pivot(array, leftIndex, rightIndex);
            quickSortHelper(array, leftIndex, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, rightIndex);
        }
    }

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Quick Sort.");

        int[] array = {3, 1, 4, 2};

        quickSort(array);

        System.out.println(Arrays.toString(array));
    }
}