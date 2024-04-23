public class DLList<T> {

    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;

        public Node(T inData){
            data = inData;
            nextNode = null;
            prevNode = null;
        }

        public Node(T inData, Node inNextNode, Node inPreviousNode){
            data = inData;
            nextNode = inNextNode;
            prevNode = inPreviousNode;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    // Create list and instantiate first entry.
    public DLList(T inData) {
        firstNode = new Node(inData);
        lastNode = firstNode;
        size++;
    }

    // Returns the size of the list.
    public int size() {
        return size;
    }

    // Prints the data in the list in a human readable way.
    public void print() {
        if (firstNode == null) {
            System.out.println("List is empty.");
            return;
        }

        String output = "";
        Node tempNode = firstNode;

        for (int x=0; x < size; ++x) {
            output += tempNode.data + " ";
            tempNode = tempNode.nextNode;
        }

        System.out.println(output);
    }

    // Adds new data to the end of the list.
    public void append(T inData) {
        Node newNode = new Node(inData);
        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.nextNode = newNode;
            newNode.prevNode = lastNode;
            lastNode = newNode;
        }
        
        size++;
    }

    // Adds new data to the start of a linked list.
    public void prepend(T inData) {
        Node newNode = new Node(inData);
        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.nextNode = firstNode;
            firstNode.prevNode = newNode;
            firstNode = newNode;
        }

        size++;
    }

    // Removes the final node in the list.
    public Node pop() {
        if (size == 0) {
            return null;
        }

        Node tempNode = lastNode;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.prevNode;
            lastNode.nextNode = null;
            tempNode.prevNode = null;
        }

        size--;

        return tempNode;
    }

    // Removes the first node in the list.
    public Node removeFirst() {
        if (size == 0) {
            return null;
        }

        Node tempNode = firstNode;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = lastNode.prevNode;
            firstNode.prevNode = null;
            tempNode.nextNode = null;
        }

        size--;

        return tempNode;
    }

    // Removes the last node in the list.
    public Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node tempNode = lastNode;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.prevNode;
            lastNode.nextNode = null;
            tempNode.nextNode = null;
        }

        size--;

        return tempNode;
    }

    // Gets a node in the list by index.
    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node tempNode = firstNode;

        // Performance increase here using divide and conquer.
        // If index is in the first half of size, iterate forward.
        // If index is in back half of the list, iterate backwards.
        if (index < size/2) {
            for (int x=0; x < index; ++x) {
                tempNode = tempNode.nextNode;
            }
        } else {
            tempNode = lastNode;
            for (int x=0; x < index; ++x) {
                tempNode = tempNode.prevNode;
            }
        }

        return tempNode;
    }

    // Sets the data of a node in the list by index.
    public boolean set(int index, T inData) {
        Node tempNode = get(index);

        if (tempNode != null) {
            tempNode.data = inData;

            return true;
        }
        return false;
    }

    // Sets the data of a node in the list by index.
    public boolean insert(int index, T inData) {
        if (index < 0 || index > size) {
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
        Node prevNode = get(index - 1);
        Node nextNode = prevNode.nextNode;

        newNode.prevNode = prevNode;
        newNode.nextNode = nextNode;

        prevNode.nextNode = newNode;
        nextNode.prevNode = newNode;

        size++;
        return true;
    }

    // Sets the data of a node in the list by index.
    public Node remove(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node tempNode = get(index);

        tempNode.nextNode.prevNode = tempNode.prevNode;
        tempNode.prevNode.nextNode = tempNode.nextNode;
        tempNode.nextNode = null;
        tempNode.prevNode = null;

        size--;
        return tempNode;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Doubly Linked List.");

        DLList<Integer> doubleLinkedList = new DLList<Integer>(1);

        doubleLinkedList.append(2);
        doubleLinkedList.append(3);

        doubleLinkedList.print();

        doubleLinkedList.pop();
        doubleLinkedList.print();

        doubleLinkedList.prepend(5);
        doubleLinkedList.print();

        System.out.println("Size: " + doubleLinkedList.size());

    }
}
