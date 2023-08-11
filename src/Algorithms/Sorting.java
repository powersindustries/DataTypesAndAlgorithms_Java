package Algorithms;

public class Sorting {

    public static void printArray(int[] inArray) {
        for (int x = 0; x < inArray.length; ++x) {
            System.out.print(inArray[x]);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] inArray) {
        for (int x = 0; x < inArray.length - 1; ++x) {
            for (int y = 0; y < inArray.length - 1; ++y) {
                if (inArray[y] > inArray[y + 1]) {
                    int tempVal = inArray[y];
                    inArray[y] = inArray[y + 1];
                    inArray[y + 1] = tempVal;
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] inArray) {
        boolean swapped = false;

        for (int x = 0; x < inArray.length - 1; ++x) {
            swapped = false;
            for (int y = 0; y < inArray.length - 1; ++y) {
                if (inArray[y] > inArray[y + 1]) {
                    int tempVal = inArray[y];
                    inArray[y] = inArray[y + 1];
                    inArray[y + 1] = tempVal;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void selectionSort(int[] inArray) {
        for (int x = 0; x < inArray.length - 1; ++x) {
            int minIndex = x;

            for (int y = x + 1; y < inArray.length; ++y) {
                if (inArray[y] < inArray[minIndex]) {
                    minIndex = y;
                }
            }

            int tempVal = inArray[minIndex];
            inArray[minIndex] = inArray[x];
            inArray[x] = tempVal;
        }
    }

    public static void insertionSort(int[] inArray) {
        for (int x = 1; x < inArray.length; ++x) {
            int currVal = inArray[x];
            int index = x - 1;

            while (index >= 0 && inArray[index] > currVal) {
                inArray[index + 1] = inArray[index];
                index = index - 1;
            }

            inArray[index + 1] = currVal;
        }
    }

    public static void mergeSort(int[] inArray, int inLow, int inHigh) {
        if (inLow < inHigh) {
            int midVal = (inLow + (inHigh - 1)) / 2;

            mergeSort(inArray, inLow, midVal);
            mergeSort(inArray, midVal + 1, inHigh);
            mergeSortArrays(inArray, inLow, inHigh, midVal);
        }
    }

    private static void mergeSortArrays(int[] inArray, int inLow, int inHigh, int inMid) {
        int size1 = inMid - inLow + 1;
        int size2 = inHigh - inMid;

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        int index = inLow;
        int indexLeft = 0;
        int indexRight = 0;

        for (int x = 0; x < size1; x++) {
            leftArray[x] = inArray[inLow + x];
        }

        for (int y = 0; y < size2; y++) {
            rightArray[y] = inArray[inMid + 1 + y];
        }

        while (indexLeft < size1 && indexRight < size2) {
            if (leftArray[indexLeft] <= rightArray[indexRight]) {
                inArray[index] = leftArray[indexLeft];
                indexLeft++;
            } else {
                inArray[index] = rightArray[indexRight];
                indexRight++;
            }
            index++;
        }

        while (indexLeft < size1) {
            inArray[index] = leftArray[indexLeft];
            indexLeft++;
            index++;
        }

        while (indexRight < size2) {
            inArray[index] = rightArray[indexRight];
            indexRight++;
            index++;
        }
    }

    public static void quickSort(int[] inArray, int inLow, int inHigh) {
        if (inLow < inHigh) {
            int partition = quickSortPartition(inArray, inLow, inHigh);
            quickSort(inArray, inLow, partition - 1);
            quickSort(inArray, partition + 1, inHigh);
        }
    }

    private static int quickSortPartition(int[] inArray, int inLow, int inHigh) {
        int pivot = inHigh;
        int index = inLow;

        for (int x = inLow; x < inHigh; ++x) {
            if (inArray[x] < inArray[pivot]) {
                int tempValue = inArray[x];
                inArray[x] = inArray[index];
                inArray[index] = tempValue;

                index++;
            }
        }

        int tempValue = inArray[pivot];
        inArray[pivot] = inArray[index];
        inArray[index] = tempValue;

        return index;
    }

}
