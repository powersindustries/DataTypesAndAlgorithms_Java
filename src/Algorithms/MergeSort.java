package Algorithms;

import java.util.Arrays;

public class MergeSort {

    // Take two sorted lists, and combine them into one that is sorted.
    public static int[] mergeTwoArrays(int[] array1, int[] array2) {
        int[] output = new int[array1.length + array2.length];
        int index = 0;
        int array1Index = 0;
        int array2Index = 0;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                output[index] = array1[array1Index];
                index++;
                array1Index++;
            } else {
                output[index] = array2[array2Index];
                index++;
                array2Index++;
            }
        }

        while (array1Index < array1.length) {
            output[index] = array1[array1Index];
            index++;
            array1Index++;
        }

        while (array2Index < array2.length) {
            output[index] = array2[array2Index];
            index++;
            array2Index++;
        }

        return output;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return mergeTwoArrays(leftArray, rightArray);
    }

    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Merge Sort.");

        int[] array = {3, 1, 4, 2};

        System.out.println(Arrays.toString(mergeSort(array)));
    }

}