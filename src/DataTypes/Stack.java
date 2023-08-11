package DataTypes;

import java.util.Arrays;

public class Stack {
    private int[] array = new int[128];
    private int topIndex;

    public Stack() {
        Arrays.fill(array, -1);
        topIndex = -1;
    }

    public void print() {
        if (topIndex < 0) {
            System.out.println("Stack is empty.");
            return;
        }

        for (int x = topIndex; x >= 0; --x) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public void push(int inData) {
        if (topIndex >= Integer.MAX_VALUE) {
            System.out.println("Stack overflow. Attempting to push value past the max value.");
            return;
        }

        topIndex += 1;
        array[topIndex] = inData;
    }

    public void pop() {
        if (topIndex < 0) {
            return;
        }

        array[topIndex] = -1;
        topIndex -= 1;
    }

    public int peek() {
        return array[topIndex];
    }


}
