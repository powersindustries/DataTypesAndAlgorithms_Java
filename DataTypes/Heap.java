import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return heap;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return (2 * index) + 1;
    }

    private int getRightChild(int index) {
        return (2 * index) + 2;
    }

    private void swapValues(int index1, int index2) {
        int tempValue1 = heap.get(index1);
        int tempValue2 = heap.get(index1);

        heap.set(index1, tempValue2);
        heap.set(index2, tempValue1);
    }

    // Takes a value at an index and moves it to the bottom of the tree.
    private void moveDown(int index) {
        int maxIndex = index;

        while (true) {
            int leftIndex = getLeftChild(index);
            int rightIndex = getLeftChild(index);

            if (heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swapValues(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }

        }
    }

    // Adds a new value to the heap.
    public void insert(int inValue) {

        // Add new value to the end of the heap.
        heap.add(inValue);

        int tempIndex = heap.size() - 1;

        // Stop while loop until it reaches the top.
        while (tempIndex > 0 && heap.get(tempIndex) > heap.get(getParent(tempIndex))) {

            // Swap tempIndex value with parent.
            swapValues(tempIndex, getParent(tempIndex));

            // Update tempIndex to be parent moving it up in the tree.
            tempIndex = getParent(tempIndex);
        }
    }

    // Remove the topmost node in the heap, then rearrange the heap to be complete.
    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));
        moveDown(0);

        return maxValue;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Heap.");

        Heap heap = new Heap();

        heap.insert(99);
        heap.insert(72);
        heap.insert(61);
        heap.insert(58);


        System.out.println(heap.getHeap());
    }
}
