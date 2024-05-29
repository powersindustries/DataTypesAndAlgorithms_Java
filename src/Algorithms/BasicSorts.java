package Algorithms;

import java.util.Arrays;

public class BasicSorts {

    public static void bubbleSort(int[] inArray) {
        for (int x = inArray.length - 1; x > 0; --x) {
            for (int y = 0; y < x; ++y) {
                if (inArray[y] > inArray[y + 1]) {
                    int tempValue = inArray[y];
                    inArray[y] = inArray[y + 1];
                    inArray[y + 1] = tempValue;
                }
            }
        }
    }

    public static void selectionSort(int[] inArray) {
        for (int x = 0; x < inArray.length; ++x) {
            int minIndex = x;

            for (int y = x+1; y < inArray.length; ++y) {
                if (inArray[y] < inArray[minIndex]){
                    minIndex = y;
                }
            }

            if (x != minIndex) {
                int tempValue = inArray[x];
                inArray[x] = inArray[minIndex];
                inArray[minIndex] = tempValue;
            }
        }
    }

    public static void insertionSort(int[] inArray) {
        for (int x = 1; x < inArray.length; ++x) {
            int tempValue = inArray[x];
            int prevIndex = x - 1;

            while(prevIndex >= 0 && tempValue < inArray[x]){
                inArray[x+1] = inArray[x];
                inArray[x] = tempValue;
                prevIndex--;
            }
        }
    }

    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Basic Sorts.");

        int[] array = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
