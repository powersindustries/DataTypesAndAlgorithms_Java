package DataTypes;

public class SLList<T> {

    public class Node {
        public T data;
        public Node nextNode;

        public Node(T inData) {
            data = inData;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    // Create list and instantiate first entry.
    public SLList(T inData) {
        Node newNode = new Node(inData);
        firstNode = newNode;
        lastNode = newNode;

        size++;
    }

    // Prints the data in the list in a human readable way.
    public void print() {
        if (size <= 1) {
            System.out.println(firstNode.data);
            return;
        }

        String output = "";
        Node tempNode = firstNode;

        for (int x = 0; x < size; ++x) {
            output += tempNode.data + " ";
            tempNode = tempNode.nextNode;
        }

        System.out.println(output);
    }

    // Adds data to the end of the list.
    public void append(T inData) {
        Node newNode = new Node(inData);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }

        size++;
    }

    // Add data to the first item in the list.
    public void prepend(T inData) {
        Node newNode = new Node(inData);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }

        size++;
    }

    // Get a node from the linked list by index.
    public Node get(int index) {
        // Safety check to make sure
        if (index < 0 || index >= size) {
            return null;
        }

        Node tempNode = firstNode;
        for (int x = 0; x < index; ++x) {
            tempNode = tempNode.nextNode;
        }

        return tempNode;
    }

    // Sets the data in a node based on index. Returns true if successful and false if unsuccessful.
    public boolean set(int index, T inData) {

        Node tempNode = get(index);
        if (tempNode != null) {
            tempNode.data = inData;

            return true;
        }

        return false;
    }

    // Adds a new node to an existing list based on index. Returns true if successful and false if unsuccessful.
    public boolean insert(int index, T inData) {
        // Safety check to make sure
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            prepend(inData);

            return true;
        }

        if (index == size) {
            append(inData);

            return true;
        }

        Node newNode = new Node(inData);
        Node tempNode = get(index - 1);

        newNode.nextNode = tempNode.nextNode;
        tempNode.nextNode = newNode;

        size++;

        return true;
    }

    // Returns the size of the list.
    public int size() {
        return size;
    }

    // Removes the last node in the list. Returns the last node that was removed.
    public Node pop() {
        if (size == 0) {
            return null;
        }

        Node tempNode = firstNode;
        Node prevNode = firstNode;

        while (tempNode.nextNode != null) {
            prevNode = tempNode;
            tempNode = tempNode.nextNode;
        }

        lastNode = prevNode;
        lastNode.nextNode = null;

        size--;

        // If the size gets decremented to 0, make sure the first and last nodes are null.
        if (size == 0) {
            firstNode = null;
            lastNode = null;
        }

        return tempNode;
    }

    // Removes the first node in the list. Returns the node that was removed.
    public Node removeFirst() {
        if (size == 0) {
            return null;
        }

        Node tempNode = firstNode;
        firstNode = firstNode.nextNode;
        tempNode.nextNode = null;

        size--;

        // If the
        if (size == 0) {
            lastNode = null;
        }

        return tempNode;
    }

    // Removes the last node in the list. Returns the node that was removed.
    public Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node tempNode = firstNode;
        Node prevNode = firstNode;

        while (tempNode.nextNode != null) {
            prevNode = tempNode;
            tempNode = tempNode.nextNode;
        }

        lastNode = prevNode;
        lastNode.nextNode = null;

        size--;

        // Account for case where size == 0.
        if (size == 0) {
            firstNode = null;
            lastNode = null;
        }

        return tempNode;
    }

    // Removes a node in the list based on index. Returns the node that was removed.
    public Node remove(int index) {
        // Safety check to make sure
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node prevNode = get(index - 1);
        Node tempNode = prevNode.nextNode;

        prevNode.nextNode = tempNode.nextNode;
        tempNode.nextNode = null;

        size--;

        return tempNode;
    }

    // Reverses the order of items in a list.
    public void reverse() {
        Node tempNode = firstNode;
        firstNode = lastNode;
        lastNode = tempNode;

        Node nextNode = tempNode.nextNode;
        Node prevNode = null;
        for (int x = 0; x < size; ++x) {
            nextNode = tempNode.nextNode;
            tempNode.nextNode = prevNode;
            prevNode = tempNode;
            tempNode = nextNode;
        }
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Single Linked List.");

        SLList<Integer> singleLinkedList = new SLList<Integer>(1);

        singleLinkedList.append(2);
        singleLinkedList.append(3);

        singleLinkedList.print();

        singleLinkedList.pop();
        singleLinkedList.print();

        singleLinkedList.prepend(5);
        singleLinkedList.print();

        singleLinkedList.removeFirst();
        singleLinkedList.print();

        singleLinkedList.set(0, 11);
        singleLinkedList.print();

        singleLinkedList.reverse();
        singleLinkedList.print();

        System.out.println("Size: " + singleLinkedList.size());

    }
}
