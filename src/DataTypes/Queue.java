package DataTypes;

public class Queue {

    private class Node {
        public int data;
        public Node nextNode;

        Node(int inData) {
            data = inData;
            nextNode = null;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public Queue(int inData) {
        Node newNode = new Node(inData);
        firstNode = newNode;
        lastNode = newNode;

        size++;
    }

    public void print() {
        String output = "";

        Node tempNode = firstNode;
        while (tempNode != null) {
            output += tempNode.data + " ";
            tempNode = tempNode.nextNode;
        }

        System.out.println(output);
    }

    // Adds a new item to the beginning of the queue.
    public void enqueue(int inData) {
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

    // Removes the first item in the queue, then returns the value that was deleted.
    public Node dequeue() {
        if (size == 0) {
            return null;
        }

        Node tempNode = firstNode;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
            return firstNode;
        } else {
            firstNode = firstNode.nextNode;
            tempNode.nextNode = null;
        }

        size--;
        return tempNode;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("DataTypes.Queue.");

        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();

        System.out.println("Dequeue: " + queue.dequeue().data);
        queue.print();
    }
}

