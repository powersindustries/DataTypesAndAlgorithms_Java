package Algorithms;

import java.util.Arrays;

public class Searching {

    // Returns -1 if searchVal was not found.
    public static int binarySearch(int[] inArray, int searchVal){
        int lowVal = 0;
        int highVal = inArray.length - 1;

        Arrays.sort(inArray);

        while (lowVal <= highVal)
        {
            int midIndex = lowVal + (highVal - lowVal) / 2;

            if (inArray[midIndex] == searchVal)
            {
                return midIndex;
            }

            if (inArray[midIndex] < searchVal)
            {
                lowVal = midIndex + 1;
            }
            else
            {
                highVal = midIndex - 1;
            }
        }
        return -1;
    }

}
